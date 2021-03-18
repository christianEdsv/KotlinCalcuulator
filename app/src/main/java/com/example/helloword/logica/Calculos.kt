package com.example.helloword.logica

import android.util.Log

/**/

open class Calculos {

    open fun Suma(numero1: Float, numero2: Float): Float{
        return numero1+numero2
    }
    open fun Resta(numero1: Float, numero2: Float): Float{
        return numero1-numero2
    }
    open fun Multiplicacion(numero1: Float, numero2: Float): Float{
        return numero1*numero2
    }
    open fun Division(numero1: Float, numero2: Float): Float{
        return numero1/numero2
    }
}