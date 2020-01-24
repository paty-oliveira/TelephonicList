/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;

/**
 *
 * @author anaoliveira
 */
public class TelephonicContact implements Serializable{
    
    protected String name;
    protected long number;
    
    public TelephonicContact(String name, long number){
        setName(name);
        setNumber(number);
    }

    public TelephonicContact(Object name, Object number) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public String getName(){
        return this.name;
    }
    
    public long getNumber(){
        return this.number;
    }
    
    private void setName(String name){
        this.name = name;
    }
    
    private void setNumber(long number){
        this.number = number;
    }
    
    @Override
    public String toString(){
        return "The number is " + this.number + " and the name is " + this.name;
    }
    
}
