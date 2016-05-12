import org.junit.Test;
import rx.Observable;
import rx.Observer;
import rx.observables.ConnectableObservable;
import rx.schedulers.Schedulers;


class ObjRpta{
    private String x;
    private String y;

    public ObjRpta(String x, String y) {
        this.x = x;
        this.y = y;
    }

    public String getX() {
        return x;
    }

    public String getY() {
        return y;
    }
}

class ObserverEjemplo implements Observer<ObjRpta>{
    public void onCompleted() {

    }

    public void onError(Throwable e) {

    }

    public void onNext(ObjRpta objRpta) {
        System.out.println("En observer " +Thread.currentThread().getId() +  " " + Thread.currentThread().getName());
        System.out.println(objRpta.getX()+" :( "+objRpta.getY());
    }
}

class ObserverEjemploLauraFeliz implements Observer<ObjRpta>{
    public void onCompleted() {

    }

    public void onError(Throwable e) {

    }

    public void onNext(ObjRpta objRpta) {
        System.out.println("En observer " +Thread.currentThread().getId() +  " " + Thread.currentThread().getName());
        System.out.println(objRpta.getX()+" :) "+objRpta.getY());
    }
}

public class RxTest {


    public  ObjRpta subirArchivo(String strRutaArchivo) {
        System.out.println("En produccion " +Thread.currentThread().getId() +  " " + Thread.currentThread().getName());
        try{
            Thread.sleep(2000);
        }catch(InterruptedException e){

        }
        return new ObjRpta("Laura", "Ruben");
    }

    @Test
    public void crearObservable(){


        System.out.println("Test " + Thread.currentThread().getId() +  " " + Thread.currentThread().getName());



        Observable obs1 = Observable.defer(() -> {
                return Observable.just(subirArchivo("Ruta del infeliz de Ruben"));
        })
        .subscribeOn(Schedulers.io())
        .observeOn(Schedulers.computation());

        Observable obs2 = Observable.create(subscriber -> {

                subscriber.onNext(subirArchivo("Ruta del infeliz de Ruben"));
                //subscriber.onCompleted();

        })
        .subscribeOn(Schedulers.io())
        .observeOn(Schedulers.computation());

        ConnectableObservable obs3 = ConnectableObservable.create(subscriber -> {

            subscriber.onNext(subirArchivo("Ruta del infeliz de Ruben"));
            //subscriber.onCompleted();

        }).publish();

        Observable obs4 = obs3.subscribeOn(Schedulers.io()).observeOn(Schedulers.computation());


        obs4.subscribe(new ObserverEjemplo());
        obs4.subscribe(new ObserverEjemploLauraFeliz());

        obs3.connect();

        try{
            Thread.sleep(4000);
        }catch(InterruptedException e){

        }

        assert(true);
    }

}
