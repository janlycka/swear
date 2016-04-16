/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swear;

/**
 *
 * @author Coburn
 */
public class Swear {

    private static String sentence_from_struct(String muster){
        
        Supplementaries.reinit();
        
        //sub-clauses
        muster = Supplementaries.action_infinitive_successful(muster);
        muster = Supplementaries.action_infinitive_unsuccessful(muster);
        
        //word primitives
        muster = Supplementaries.noun_pos(muster);
        muster = Supplementaries.noun_neg(muster);
        muster = Supplementaries.adj_pos(muster);
        muster = Supplementaries.adj_neg(muster);
        
        //System.out.println(Supplementaries.rod_store);
        
        //System.out.println("");
        return muster.replace('_', ' ');
    }
    
    private static String sentence(int rank){
        switch(rank){
            case 1: return sentence_from_struct("Jsi *adj_neg *adj_neg *adj_neg *noun_neg1, co ani neumi *action_infinitive_successful.");
            case 2: return sentence_from_struct("Tvoje matka byla *adj_neg *adj_neg *noun_neg1f, fotr *adj_neg *adj_neg *noun_neg1m.");
            case 3: return sentence_from_struct("Jsi vyplod *adj_neg *noun_neg2 a *adj_neg *noun_neg2 co dovedou jen *action_infinitive_unsuccessful.");
            case 4: return sentence_from_struct("Nejsi nic vic nez *adj_neg *adj_neg *adj_neg *noun_neg1, co netusi jak *action_infinitive_successful doufaje ze by v budoucnu mohl *action_infinitive_successful.");
        }
        return "";
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String result = "";
        
        result += "\n"+sentence(1);
        result += "\n"+sentence(2);
        result += "\n"+sentence(3);
        result += "\n"+sentence(4);
        
        System.out.println(result);
    }
    
}
