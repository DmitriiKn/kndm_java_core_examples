package interfases;

public class SealedHierarchy {
}

sealed interface Shape permits Qube, Triangle{
    void draw();
}

non-sealed interface Qube extends Shape{

}

sealed interface Triangle extends Shape permits DoubleTriangle{

}

non-sealed class DoubleTriangle implements Triangle {
    @Override
    public void draw() {
    }
}


/**
 * Hierarchy error here because Triangle doesn't permit to TripleTriangle
// */
//non-sealed class TripleTriangle implements Triangle {
//    @Override
//    public void draw() {
//    }
//}


