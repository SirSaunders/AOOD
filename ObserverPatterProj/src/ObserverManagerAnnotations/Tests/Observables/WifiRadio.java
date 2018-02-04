package ObserverManagerAnnotations.Tests.Observables;

import ObserverManager.Data;
import ObserverManager.Observable;

/**
 * Created by johnathansaunders on 2/1/18.
 */
public class WifiRadio implements Observable{

    private void update(Data data){
        observerManager.notifyAllUpdate(data);
    }
}
