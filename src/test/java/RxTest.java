import org.junit.Test;
import rx.Observable;
import rx.observables.ConnectableObservable;
import rx.schedulers.Schedulers;

public class RxTest {

    @Test
    public void crearObservable() {

        System.out.println("Test " + Thread.currentThread().getId() + " " + Thread.currentThread().getName());

        ConnectableObservable obs1 = Observable.defer(() -> {
            return Observable.just(new ArchivosServices().subirArchivo("Ruta del infeliz de Ruben"));
        }).subscribeOn(Schedulers.io())
          .observeOn(Schedulers.computation())
          .publish();

        obs1.subscribe(new ObserverEjemplo());
        obs1.subscribe(new ObserverEjemploLauraFeliz());

        obs1.connect();

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {

        }

        assert (true);
    }
}
