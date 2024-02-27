package dam.clases.cronometro;

public class Cronometro {
    private Cronometro [] cron;
    private final long time1970;
    private long time;
    private long stopTime;

    public Cronometro (int cantidad) {
        this.cron = new Cronometro[cantidad];
        this.time1970 = System.currentTimeMillis();
        this.time = 0;
        this.stopTime = 0;
    }

    public long reset (int n) {
        this.cron[n].time = 0;
        return this.time;
    }

    // reseta a todos
    public void resetTodos () {
        for (int i = 0; i <  this.cron.length; i++) {
            this.reset(i);
        }
    }

    //por donde va
    public long peek(int n) {
        return this.time;
    }

    // para cron
    public long stop(int n) {
        this.time = this.time - this.time1970;
        return this.time;
    }

    // run cron
    public long start (int n) {
        this.time = System.currentTimeMillis() - this.time1970;
        return this.time;
    }
}