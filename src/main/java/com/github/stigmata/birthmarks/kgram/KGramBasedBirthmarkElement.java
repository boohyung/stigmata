package com.github.stigmata.birthmarks.kgram;

import java.io.Serializable;

import com.github.stigmata.BirthmarkElement;

/**
 * 
 * @author Haruaki TAMADA
 */
public class KGramBasedBirthmarkElement<T extends Serializable> extends BirthmarkElement{
    private static final long serialVersionUID = 28546543857543634L;

    private KGram<T> kgram;

    public KGramBasedBirthmarkElement(KGram<T> kgram){
        super(kgram.toString());
        this.kgram = kgram;
    }

    @Override
    @SuppressWarnings("rawtypes")
    public boolean equals(Object o){
        return o instanceof KGramBasedBirthmarkElement &&
            kgram.equals(((KGramBasedBirthmarkElement)o).kgram);
    }

    @Override
    public int hashCode(){
        int v = kgram.hashCode();

        return (v & 0xff << 24) | (v >> 8); 
    }
}
