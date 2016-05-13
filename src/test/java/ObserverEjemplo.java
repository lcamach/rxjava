import rx.Observer;

class ObserverEjemplo implements Observer<ObjRpta> {
    public void onCompleted() {

    }

    public void onError(Throwable e) {

    }

    public void onNext(ObjRpta objRpta) {
        System.out.println("En observer " + Thread.currentThread().getId() + " " + Thread.currentThread().getName());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {

        }
    }
}