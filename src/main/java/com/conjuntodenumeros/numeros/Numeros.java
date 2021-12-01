package com.conjuntodenumeros.numeros;

import com.sun.javafx.beans.IDProperty;

public class Numeros {

    private Integer paginas;

    public Numeros() {
    }

    public Integer getPaginas() {
        return paginas;
    }

    public void setPaginas(Integer paginas) {
        this.paginas = paginas;
    }

    @Override
    public String toString() {
        return "Numeros{" +
                "paginas='" + paginas + '\'' +
                '}';
    }
}
