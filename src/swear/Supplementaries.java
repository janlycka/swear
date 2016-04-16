/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swear;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Coburn
 */
public class Supplementaries {
    
    private static int [] pad_store = new int [128];
    public static char [] rod_store = new char [128];
    
    public static void reinit(){
        for(int i=0; i<128; i++){
            pad_store[i]=0;
            rod_store[i]=0;
        }
    }
    
    private static int padAtLocation(int loc){
        for(int i=loc; i<128; i++)
            if(pad_store[i]!=0){
                //System.out.println("pad at "+loc+" ("+i+") is "+pad_store[i]);
                return pad_store[i];
            }
        return -1;
    }
    
    private static char genderAtLocation(int loc){
        for(int i=loc; i<128; i++)
            if(rod_store[i]>'a' && rod_store[i]<'z'){
                //System.out.println("gender at "+loc+" is "+rod_store[i]);
                return rod_store[i];
            }
        return '-';
    }
    
    private static void set_pad_gender(int pad, char gender, int location){
        pad_store[location] = pad;
        rod_store[location] = gender;
                //System.out.println("setting : pad at "+location+" is "+pad_store[location]);
    }
    
    public static void set_gender(char gender, int location){
        rod_store[location] = gender;
                //System.out.println("setting : gender at "+location+" is "+rod_store[location]);
    }
    
    private static String refactor(String key, String muster){
        while(muster.contains("*"+key)){
            int i = muster.indexOf("*"+key, 0);
            int pad;
            char rod=' ';
            int n = 0;
            
                String str = muster.substring(0, i);
                int cnt=0;
                for(int c=0; c<str.length(); c++)if(str.charAt(c)==' ')cnt++;
            
            if(key.contains("noun")){
                n = 1;
                pad = Integer.parseInt(muster.substring(i+key.length()+1, i+key.length()+2));
                if(i+key.length()+2 < muster.length()){
                    char potential_rod = (muster.substring(i+key.length()+2, i+key.length()+3)).toCharArray()[0];
                    if(potential_rod=='m' || potential_rod=='f' || potential_rod=='n' || potential_rod=='p'){
                        rod = potential_rod;
                        n++;
                    }
                }
                set_pad_gender(pad,rod,cnt);
            }
            else{
                //find next noun to the right
                pad = padAtLocation(cnt);
                rod = genderAtLocation(cnt);
            }
            
            muster = muster.substring(0, i) + word_from_dbase(key, muster,pad,rod,cnt) + muster.substring(i+key.length()+1+n);
        }
        return muster;
    }
    
    public static String word_from_dbase(String key, String muster, int p, char rod, int location){
        switch(key){
            case "adj_pos": return rand_db_adj(Ressources.adj_pos,p,rod);
            case "adj_neg": return rand_db_adj(Ressources.adj_neg,p,rod);
            case "noun_pos": return rand_db_noun(p,true,location,rod);
            case "noun_neg": return rand_db_noun(p,false,location,rod);
            /*case "verb_pos": return rand_db_verb(Ressources.verb_pos,p);
            case "verb_neg": return rand_db_verb(Ressources.verb_neg,p);*/
            case "action_infinitive_successful": return rand_db_word(Ressources.action_infinitive_successful);
            case "action_infinitive_unsuccessful": return rand_db_word(Ressources.action_infinitive_unsuccessful);
        }
        return "-";
    }
    
    private static Random r = null;
    private static List<Integer> blackList = new ArrayList<>();
    private static List<Integer> blackListsent = new ArrayList<>();
    
    public static String rand_db_adj(String [] db, int pad, char rod){
        if(r==null)r = new Random();
        int selected = r.nextInt(db.length);
        while(blackList.contains(selected))
            selected = r.nextInt(db.length);
        blackList.add(selected);
        return Ressources.conjugate_adj(db[selected],pad,rod);
    }
    
    public static String rand_db_noun(int pad, boolean mood, int l, char rod){
        return Ressources.generate_conjugate_noun(pad,mood,l,rod);
    }
    /*
    public static String rand_db_verb(String [] db, int person){
        if(r==null)r = new Random();
        return Ressources.conjugate_verb(db[r.nextInt(db.length-1)],person);
    }*/
    
    public static String rand_db_word(String [] db){
        if(r==null)r = new Random();
        int selected = r.nextInt(db.length);
        while(blackListsent.contains(selected))
            selected = r.nextInt(db.length);
        blackListsent.add(selected);
        return db[selected];
    }
    
    public static String adj_pos(String muster){
        return refactor("adj_pos",muster);
    }
    
    public static String adj_neg(String muster){
        return refactor("adj_neg",muster);
    }
    
    public static String noun_pos(String muster){
        return refactor("noun_pos",muster);
    }
    
    public static String noun_neg(String muster){
        return refactor("noun_neg",muster);
    }
    
    public static String verb_pos(String muster){
        return refactor("verb_pos",muster);
    }
    
    public static String verb_neg(String muster){
        return refactor("verb_neg",muster);
    }
    
    public static String action_infinitive_successful(String muster){
        return refactor("action_infinitive_successful",muster);
    }
    
    public static String action_infinitive_unsuccessful(String muster){
        return refactor("action_infinitive_unsuccessful",muster);
    }
}
