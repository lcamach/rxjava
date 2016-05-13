import rx.Observer;

class ObserverEjemploLauraFeliz implements Observer<ObjRpta> {
    public void onCompleted() {

    }

    public void onError(Throwable e) {

    }

    public void onNext(ObjRpta objRpta) {
        System.out.println("En observer " + Thread.currentThread().getId() + " " + Thread.currentThread().getName());
        System.out.println(objRpta.getX() + " :) " + objRpta.getY());
    }
}