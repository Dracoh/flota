/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.flota.bean;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.flota.Seguro;

/**
 *
 * @author hectorsantossv
 */
@Stateless
public class SeguroFacade extends AbstractFacade<Seguro> {

    @PersistenceContext(unitName = "flotaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SeguroFacade() {
        super(Seguro.class);
    }
    
}
