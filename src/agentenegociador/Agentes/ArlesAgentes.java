/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agentenegociador.Agentes;

import java.util.Random;
import java.util.Vector;
import negoUPV.UPVAgent;
import negotiator.Bid;

/**
 *
 * @author unitec01
 */
public class ArlesAgentes extends UPVAgent{
    
    //This variable is used to store the last offer sent to the opponent
	Bid b_last_offer_sent=null;
	
	@Override
	public boolean acceptOffer(Bid offer) {
            // TODO Auto-generated method stub
            // Accept bid if it improves the utility of the last offer sent
            if (this.getUtility(offer) > getUtility(this.b_last_offer_sent)) {
                return true;
            } else {
                return false;   
            }
	}

	@Override
	public void initialize() {
            // TODO Auto-generated method stub
            rand=new Random(System.currentTimeMillis()+this.getName().hashCode());
	}

	@Override
	public Bid proposeOffer() {
            // TODO Auto-generated method stub

            //Get all of the possible bids (discrete domains) or a maximum of 250 bids with a utility between 0 and 1
            Vector<Bid> m_bids= getOffers(0, 1);

            //Select one of those bids randomly
            Bid selected=m_bids.get(rand.nextInt(m_bids.size()));
            b_last_offer_sent=selected;
            //Send the offer
            return b_last_offer_sent;
		
	}
    
}
