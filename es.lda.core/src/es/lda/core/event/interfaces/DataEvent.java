package es.lda.core.event.interfaces;

/**
 *
 * @author Jose Antonio
 */
public interface DataEvent {

//    /**
//     * Event.
//     * @param size integer.
//     */
//    public void dataArrival(int size);

    /**
     * Event.
     * @param size short.
     */
    public void dataArrival(short size) throws GUIEvent;
}