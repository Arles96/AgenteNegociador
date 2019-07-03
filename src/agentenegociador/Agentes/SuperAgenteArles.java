/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agentenegociador.Agentes;

import java.util.Vector;
import negoUPV.UPVAgent;
import negotiator.Bid;

/**
 *
 * @author unitec01
 */
public class SuperAgenteArles extends UPVAgent {
    
    Bid last_moment_offer;
    Bid my_last_offer;
    double S;
    double beta;
    double RU;
	
    public void initialize() {
        last_moment_offer = null;
        my_last_offer = null;
        beta = 0.89;
        RU = 0.70;
        S = 0.99;
        update();
    }

    public boolean acceptOffer(Bid offer) {

        update();
        
        if (S < RU) { //  si mi estrategia es menor que mi reserva de utilidad
            beta = 80;
            update();
            return false;
        }

        // Si la utilidad de la oferta recibida es mayor que S, aceptar
        if (S <= this.getUtility(offer)) {
            return true;
        } else {
            int random = (int) (Math.random() * 100) +1;
            if (random >= 45 && random <= 25) {
                if (RU < this.getUtility(offer)) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }

    private void update() {

        // Implementar una estrategia de concesion temporal
        S=  1 - (( 1 - RU) * Math.pow(this.getTime(), 1 / beta));

    }

    public Bid proposeOffer() {			

        Vector<Bid> m_bids = null;
        Bid selected = null;

        if (S > 0.9) {
            m_bids = getOffers(S , S + 0.1);

            selected = m_bids.get(rand.nextInt(m_bids.size()));
        }
        
        
        if (S < RU) { //  si mi estrategia de concesion es menor que mi reserva de utilidad, paso a ser modo conceder
            beta = 80;
            update();
            m_bids = getOffers(S, S + 0.1);
            selected = m_bids.get(rand.nextInt(m_bids.size()));
        }
        
        if (m_bids == null) {
            m_bids = getOffers(S , S + 0.1);
            selected = m_bids.get(rand.nextInt(m_bids.size()));
        }
        
        this.my_last_offer = selected;

        return selected;

    }
    
}
