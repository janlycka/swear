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
public class Ressources {
    
    //word primitives
    public static String [] adj_pos = {"chytry", "inteligentni"};
    public static String [] adj_neg = {"blby", "debilni", "zamindrakovany", "posrany", "vymrdany", "z_prdele_vysrany", "z_buzerantova_udu_vystriknuty", "zasrany", "zkurveny", "dementni", "vyjebany", "pojebany", "z_nosu_vydlabany", "idioticky", "rozmrdany", "postizeny", "neschopny", "bezdomovecky", "labilni", "na_psychoanalyzu_zraly", "lobotomovany", "kasparsky", "nechutny", "prohnily", "odporny", "zrudny", "praseci", "skopovy", "nechapajici", "pomaly", "slaboduchy", "miniaturni", "otupely", "v_hlave_porouchany", "sibly", "kratkozraky", "na_radici_pace_sedici", "svratky_olizujici", "teply", "degenerovany", "irelevantni", "nestabilni", "nenormalni", "opravdu_divny", "ubohy", "nestastny", "osamoceny", "HIV_pozitivni", "nevzdelany", "ze_skoly_vyhozeny", "drogy_konzumujici", "primitivni", "opovrzenihodny", "nemozny", "pochcany", "v_hovnech_se_valici", "penis_nemajici", "analfabeticky", "vesnicky", "amoralni", "neartikulujici", "bohuzel_narozeny", "nedolezity", "obecne_spatny"};
    
    public static String [] noun_pan_pos = {"normalni clovek", "intelektual", "chlap"};
    public static String [] noun_pan_neg = {"retard", "debil", "zmrd", "idiot", "labil", "magor", "blazen", "psychopat", "buzerant", "curak", "dement", "fetak", "hovnoksicht", "kokot", "konomrd", "kreten", "kripl", "kurvak", "kurburt", "mrduch", "posuk", "uchyl", "zik", "zoofil"};
    public static String [] noun_hrad_pos = {};
    public static String [] noun_hrad_neg = {"ud", "vred", "prdeloid"};
    public static String [] noun_muz_pos = {};
    public static String [] noun_muz_neg = {"picus", "kun", "hovnous"};
    public static String [] noun_stroj_pos = {};
    public static String [] noun_stroj_neg = {"hnuj", "puchyr"};
    public static String [] noun_predseda_pos = {};
    public static String [] noun_predseda_neg = {"komunista", "nacista", "fasista", "posera", "trouba"};
    public static String [] noun_soudce_pos = {};
    public static String [] noun_soudce_neg = {"blbec", "pitomec", "zbabelec", "tupec", "vyjebanec"};
    
    public static String [] noun_zena_pos = {"normalni zena"};
    public static String [] noun_zena_neg = {"kurva", "krava", "pica", "devka", "sracka", "sprcka", "cubka", "dylina", "kedra", "koza", "kunda", "pipina", "smazka", "trubka", "buzna"};
    public static String [] noun_ruze_pos = {};
    public static String [] noun_ruze_neg = {"svine"};
    public static String [] noun_pisen_pos = {};
    public static String [] noun_pisen_neg = {"chuj", "prdel"};
    public static String [] noun_kost_pos = {};
    public static String [] noun_kost_neg = {};
    
    public static String [] noun_mesto_pos = {};
    public static String [] noun_mesto_neg = {"hovado", "vacatko", "prasatko", "hovno"};
    public static String [] noun_more_pos = {};
    public static String [] noun_more_neg = {};
    public static String [] noun_kure_pos = {};
    public static String [] noun_kure_neg = {};
    public static String [] noun_staveni_pos = {};
    public static String [] noun_staveni_neg = {};
    
    public static String [] noun_neg_pl = {"picoviny", "hovadiny", "kraviny", "sracky"};
    /*
    public String [] adj_neg = {"blby", "debilni"};
    public String [] adj_neg = {"blby", "debilni"};*/
    
    //sub-sentences
    public static String [] action_infinitive_successful = {"rozeznat *adj_neg *noun_neg4 jako jeho fotr od *adj_neg *noun_neg2 jako je sam", "*action_infinitive_unsuccessful a nanejvyse muze *action_infinitive_unsuccessful","precist si o *noun_neg6n v novinach","rozlisit *adj_neg *neg_noun1 od *adj_neg *neg_noun2","najit *adj_neg *noun_neg1","najit svoje rodice","vysrat vlastni hovno","precist text na tabuli","ziskat jedinou dobrou znamku ve skole","cokoliv realizovat v zivote"};
    public static String [] action_infinitive_unsuccessful = {"sezrat svoje vlastni hovno", "nasrat si sam sobe na hlavu", "placat debilni sracky","si sotva zavazat tkanicky", "si nadojit sracky svy babicky do hrdla", "mrdat se do riti", "honit se v prdeli plesnivym bananem", "fetovat hovna jako za mlada"};
    
    
    private static Random r = null;
    private static List<Integer> blackList = new ArrayList<>();
    
    //nouns
    public static String generate_conjugate_noun(int pad, boolean mood, int loc, char rod){
        pad--;
        //total count of eligible words
        int candidates_count=0;
        int masc=0, fem=0, neutr=0;
        
        //retreive total count of eligible words
        if(mood){
            masc = noun_pan_pos.length + noun_hrad_pos.length + noun_muz_pos.length + noun_stroj_pos.length + noun_predseda_pos.length + noun_soudce_pos.length;
            fem = noun_zena_pos.length + noun_ruze_pos.length + noun_pisen_pos.length + noun_kost_pos.length;
            neutr = noun_mesto_pos.length + noun_more_pos.length + noun_kure_pos.length + noun_staveni_pos.length;
            candidates_count = masc+fem+neutr;
        }
        else{
            masc = noun_pan_neg.length + noun_hrad_neg.length + noun_muz_neg.length + noun_stroj_neg.length + noun_predseda_neg.length + noun_soudce_neg.length;
            fem = noun_zena_neg.length + noun_ruze_neg.length + noun_pisen_neg.length + noun_kost_neg.length;
            neutr = noun_mesto_neg.length + noun_more_neg.length + noun_kure_neg.length + noun_staveni_neg.length;
            candidates_count = masc+fem+neutr;
        }
            
        
        //used when preferred gender 'rod' is set
        int lowerlimit = 0;
        int upperlimit = candidates_count;
        
        switch(rod){
            case 'm': upperlimit=masc; break;
            case 'f': lowerlimit=masc; upperlimit=fem+masc; break;
            case 'n': lowerlimit=fem+masc; break;
            default: break;
        }
        
        //generate sought noun index
        if(r==null)r = new Random();
        int selected = lowerlimit+r.nextInt(upperlimit-lowerlimit);
        
        while(blackList.contains(selected))
            selected = lowerlimit+r.nextInt(upperlimit-lowerlimit);
        blackList.add(selected);
        String noun="";
        
        int progress = 0;
        int grammar_rule = 0;
        if(mood){
            if(selected < progress+noun_pan_pos.length && grammar_rule == 0){ noun=noun_pan_pos[selected-progress]; grammar_rule = 10; Supplementaries.set_gender('m', loc);} progress+=noun_pan_pos.length;
            if(selected < progress+noun_hrad_pos.length && grammar_rule == 0){ noun=noun_hrad_neg[selected-progress];grammar_rule = 11; Supplementaries.set_gender('m', loc);} progress+=noun_hrad_pos.length;
            if(selected < progress+noun_muz_pos.length && grammar_rule == 0){ noun=noun_muz_neg[selected-progress];grammar_rule = 12; Supplementaries.set_gender('m', loc);} progress+=noun_muz_pos.length;
            if(selected < progress+noun_stroj_pos.length && grammar_rule == 0){ noun=noun_stroj_neg[selected-progress];grammar_rule = 13; Supplementaries.set_gender('m', loc);} progress+=noun_stroj_pos.length;
            if(selected < progress+noun_predseda_pos.length && grammar_rule == 0){ noun=noun_predseda_neg[selected-progress];grammar_rule = 14; Supplementaries.set_gender('m', loc);} progress+=noun_predseda_pos.length;
            if(selected < progress+noun_soudce_pos.length && grammar_rule == 0){ noun=noun_soudce_neg[selected-progress];grammar_rule = 15; Supplementaries.set_gender('m', loc);} progress+=noun_soudce_pos.length;
            if(selected < progress+noun_zena_pos.length && grammar_rule == 0){ noun=noun_zena_neg[selected-progress];grammar_rule = 20; Supplementaries.set_gender('f', loc);} progress+=noun_zena_pos.length;
            if(selected < progress+noun_ruze_pos.length && grammar_rule == 0){ noun=noun_ruze_neg[selected-progress];grammar_rule = 21; Supplementaries.set_gender('f', loc);} progress+=noun_ruze_pos.length;
            if(selected < progress+noun_pisen_pos.length && grammar_rule == 0){ noun=noun_pisen_neg[selected-progress];grammar_rule = 22; Supplementaries.set_gender('f', loc);} progress+=noun_pisen_pos.length;
            if(selected < progress+noun_kost_pos.length && grammar_rule == 0){ noun=noun_kost_neg[selected-progress];grammar_rule = 23; Supplementaries.set_gender('f', loc);} progress+=noun_kost_pos.length;
            if(selected < progress+noun_mesto_pos.length && grammar_rule == 0){ noun=noun_mesto_neg[selected-progress];grammar_rule = 30; Supplementaries.set_gender('n', loc);} progress+=noun_mesto_pos.length;
            if(selected < progress+noun_more_pos.length && grammar_rule == 0){ noun=noun_more_neg[selected-progress];grammar_rule = 31; Supplementaries.set_gender('n', loc);} progress+=noun_more_pos.length;
            if(selected < progress+noun_kure_pos.length && grammar_rule == 0){ noun=noun_kure_neg[selected-progress];grammar_rule = 32; Supplementaries.set_gender('n', loc);} progress+=noun_kure_pos.length;
            if(selected < progress+noun_staveni_pos.length && grammar_rule == 0){ noun=noun_staveni_neg[selected-progress];grammar_rule = 33; Supplementaries.set_gender('n', loc);} progress+=noun_staveni_pos.length;
        }
        else{
            if(selected < progress+noun_pan_neg.length && grammar_rule == 0){ noun=noun_pan_neg[selected-progress]; grammar_rule = 10; Supplementaries.set_gender('m', loc);} progress+=noun_pan_neg.length;
            if(selected < progress+noun_hrad_neg.length && grammar_rule == 0){ noun=noun_hrad_neg[selected-progress];grammar_rule = 11; Supplementaries.set_gender('m', loc);} progress+=noun_hrad_neg.length;
            if(selected < progress+noun_muz_neg.length && grammar_rule == 0){ noun=noun_muz_neg[selected-progress];grammar_rule = 12; Supplementaries.set_gender('m', loc);} progress+=noun_muz_neg.length;
            if(selected < progress+noun_stroj_neg.length && grammar_rule == 0){ noun=noun_stroj_neg[selected-progress];grammar_rule = 13; Supplementaries.set_gender('m', loc);} progress+=noun_stroj_neg.length;
            if(selected < progress+noun_predseda_neg.length && grammar_rule == 0){ noun=noun_predseda_neg[selected-progress];grammar_rule = 14; Supplementaries.set_gender('m', loc);} progress+=noun_predseda_neg.length;
            if(selected < progress+noun_soudce_neg.length && grammar_rule == 0){ noun=noun_soudce_neg[selected-progress];grammar_rule = 15; Supplementaries.set_gender('m', loc);} progress+=noun_soudce_neg.length;
            if(selected < progress+noun_zena_neg.length && grammar_rule == 0){ noun=noun_zena_neg[selected-progress];grammar_rule = 20; Supplementaries.set_gender('f', loc);} progress+=noun_zena_neg.length;
            if(selected < progress+noun_ruze_neg.length && grammar_rule == 0){ noun=noun_ruze_neg[selected-progress];grammar_rule = 21; Supplementaries.set_gender('f', loc);} progress+=noun_ruze_neg.length;
            if(selected < progress+noun_pisen_neg.length && grammar_rule == 0){ noun=noun_pisen_neg[selected-progress];grammar_rule = 22; Supplementaries.set_gender('f', loc);} progress+=noun_pisen_neg.length;
            if(selected < progress+noun_kost_neg.length && grammar_rule == 0){ noun=noun_kost_neg[selected-progress];grammar_rule = 23; Supplementaries.set_gender('f', loc);} progress+=noun_kost_neg.length;
            if(selected < progress+noun_mesto_neg.length && grammar_rule == 0){ noun=noun_mesto_neg[selected-progress];grammar_rule = 30; Supplementaries.set_gender('n', loc);} progress+=noun_mesto_neg.length;
            if(selected < progress+noun_more_neg.length && grammar_rule == 0){ noun=noun_more_neg[selected-progress];grammar_rule = 31; Supplementaries.set_gender('n', loc);} progress+=noun_more_neg.length;
            if(selected < progress+noun_kure_neg.length && grammar_rule == 0){ noun=noun_kure_neg[selected-progress];grammar_rule = 32; Supplementaries.set_gender('n', loc);} progress+=noun_kure_neg.length;
            if(selected < progress+noun_staveni_neg.length && grammar_rule == 0){ noun=noun_staveni_neg[selected-progress];grammar_rule = 33; Supplementaries.set_gender('n', loc);} progress+=noun_staveni_neg.length;
        }
        //String res = "";
        String stem = noun;
        
        //apply appropriate grammar rule
        switch(grammar_rule){
            //pan
            case 10: return stem+conjuagtion_postfixes_noun_pan[pad];
            //hred
            case 11: return stem+conjuagtion_postfixes_noun_hrad[pad];
            //muz
            case 12: return stem+conjuagtion_postfixes_noun_muz[pad];
            //stroj
            case 13: return stem+conjuagtion_postfixes_noun_stroj[pad];
            //predseda
            case 14:
                     stem = stem.substring(0,stem.length()-1);
                     return stem+conjuagtion_postfixes_noun_predseda[pad];
            //soudce
            case 15: if(stem.substring(stem.length()-2).equals("ec")){
                        if(pad==0){
                             return stem;
                        }
                        else
                            stem = stem.substring(0,stem.length()-2)+"c";
                    }
                return stem+conjuagtion_postfixes_noun_soudce[pad];
                
            //zena
            case 20: stem = stem.substring(0,stem.length()-1); return stem+conjuagtion_postfixes_noun_zena[pad];
            //ruze
            case 21: stem = stem.substring(0,stem.length()-1); return stem+conjuagtion_postfixes_noun_ruze[pad];
            //pisen
            case 22: if(stem.substring(stem.length()-2).equals("el") || stem.substring(stem.length()-2).equals("uj")){
                        if(pad==0 || pad==3 || pad==4) return stem;
                        stem = stem.substring(0,stem.length()-1); return stem+conjuagtion_postfixes_noun_pisen[pad].replace('n', stem.substring(stem.length()-1).toCharArray()[0]);
                    }
                    stem = stem.substring(0,stem.length()-2); return stem+conjuagtion_postfixes_noun_pisen[pad];
            //kost
            case 23: return stem+conjuagtion_postfixes_noun_kost[pad];
                
            //mesto
            case 30: stem = stem.substring(0,stem.length()-1); return stem+conjuagtion_postfixes_noun_mesto[pad];
            //more
            case 31: stem = stem.substring(0,stem.length()-1); return stem+conjuagtion_postfixes_noun_more[pad];
            //kure
            case 32: return stem+conjuagtion_postfixes_noun_pisen[pad];
            //staveni
            case 33: return stem+conjuagtion_postfixes_noun_kost[pad];
        }
        
        return "--";
    }
    private static String [] conjuagtion_postfixes_noun_pan = {"","a","ovi","a","e","u","em"};
    private static String [] conjuagtion_postfixes_noun_hrad = {"","u","u","","e","u","em"};
    private static String [] conjuagtion_postfixes_noun_muz = {"","e","i","e","i","i","em"};
    private static String [] conjuagtion_postfixes_noun_stroj = {"","e","i","","i","i","em"};
    private static String [] conjuagtion_postfixes_noun_predseda = {"a","y","ovi","u","o","ovi","ou"};
    private static String [] conjuagtion_postfixes_noun_soudce = {"e","e","i","e","e","i","em"};
    
    private static String [] conjuagtion_postfixes_noun_zena = {"a","y","e","u","o","e","ou"};
    private static String [] conjuagtion_postfixes_noun_ruze = {"e","e","i","i","e","i","i"};
    private static String [] conjuagtion_postfixes_noun_pisen = {"en","ne","ni","en","en","ni","ni"};
    private static String [] conjuagtion_postfixes_noun_kost = {"","i","i","","","i","i"};
    
    private static String [] conjuagtion_postfixes_noun_mesto = {"o","a","u","o","o","e","em"};
    private static String [] conjuagtion_postfixes_noun_more = {"e","e","i","e","e","i","em"};
    private static String [] conjuagtion_postfixes_noun_kure = {"","te","ti","","","ti","tem"};
    private static String [] conjuagtion_postfixes_noun_staveni = {"","","","","","","m"};
    
    
    //adjectives
    public static String conjugate_adj(String slovo, int pad, char rod){
        String lastletter = slovo.substring(slovo.length()-1);
        pad--;
        int padding=0;
        
        switch(rod){
            case 'm': padding=0; break;
            case 'f': padding=7; break;
            case 'n': padding=14; break;
            case 'p': padding=21; break;
        }
        
        String stem = slovo;
        
        switch(lastletter){
            case "y":
                stem = stem.substring(0,slovo.length()-1);
                return stem+conjuagtion_postfixes_adj_y[padding+pad];
                
            case "i":
                //stem = stem.substring(0,slovo.length()-1);
                return stem+conjuagtion_postfixes_adj_i[padding+pad];
        }
        
        return "";
    }
    private static String [] conjuagtion_postfixes_adj_y = {"y","eho","emu","eho","y","em","ym","a","e","e","ou","a","e","ou","e","eho","emu","e","e","em","ym","i","ich","ym","e","i","ich","ymi"};
    private static String [] conjuagtion_postfixes_adj_i = {"","ho","mu","ho","","m","m","","","","","","","","","ho","mu","","","m","m","","ch","m","","","ch","mi"};
}
