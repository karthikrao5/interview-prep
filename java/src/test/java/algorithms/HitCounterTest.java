package algorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HitCounterTest {

    @Test
    void handlesCounting() {
        HitCounter counter = new HitCounter();

        counter.hit(1);
        counter.hit(2);
        counter.hit(3);

        assertEquals(3, counter.getHits(4));

        counter.hit(300);

        assertEquals(4, counter.getHits(300));
        assertEquals(3, counter.getHits(301));
    }

    @Test
    void handlesCountingCase2() {
        HitCounter counter = new HitCounter();

        counter.hit(1);
        counter.hit(2);
        counter.hit(3);
    }
}
