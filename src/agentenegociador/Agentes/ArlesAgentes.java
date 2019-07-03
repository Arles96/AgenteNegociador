/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agentenegociador.Agentes;

import negoUPV.UPVAgent;
import negotiator.Bid;

/**
 *
 * @author unitec01
 */
public class ArlesAgentes extends UPVAgent{
    
    Bid mi_ultima_oferta;
    double S;
    double beta;
    double RU;
    

    @Override
    public void initialize() {
        mi_ultima_oferta = null;
        beta = 0.50;
        RU =  0.75;
        S = 0.70;
    }

    @Override
    public Bid proposeOffer() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean acceptOffer(Bid bid) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
