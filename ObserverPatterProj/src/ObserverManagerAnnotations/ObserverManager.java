package ObserverManagerAnnotations;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by johnathansaunders on 2/1/18.
 */
public class ObserverManager {
    static private ObserverManager observerManager;

    private ObserverManager(){

    }

  synchronized static public ObserverManager getInstance(){
        if (observerManager == null){
            observerManager = new ObserverManager();
        }
        return observerManager;
    }
      public void notifyAllUpdata(Data data){
        for (Method m : Observer.class.getMethods()) {
            Observer mXY = (Observer)m.getAnnotation(Observer.class);
                    try {
                        m.invoke(data);
                    } catch (IllegalAccessException e) {
                        //do nothing;
                    } catch (InvocationTargetException o) {
                        //do nothing;
                    }

        }
    }
}
