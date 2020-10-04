import telran.actors.MsgConsumer;
import telran.actors.MsgProducer;
import telran.mediation.BlkQueue;
import telran.mediation.IBlkQueue;

public class ProducerConsumeAppl {

	private static final int N_MESSAGES = 50;     //количество мессаджей 50 
	private static final int N_CONSUMERS = 5;     //получателей 5
	private static final int MSG_SEND_INTERVAL_MILLIS = 100;     //интервал отправителя
	private static final int MSG_HANDLING_TIME_MILLIS = 1000;     //интервал получателей
	private static final int QUEUE_MAX_SIZE = 10;        //максимальный размер очереди

	public static void main(String[] args) throws InterruptedException {
		IBlkQueue<String> blkQueue = new BlkQueue<>(QUEUE_MAX_SIZE);
		MsgProducer sender = new MsgProducer(blkQueue, N_MESSAGES, MSG_SEND_INTERVAL_MILLIS);
		sender.start();
		for (int i = 0; i < N_CONSUMERS; i++) {
			new MsgConsumer(blkQueue, MSG_HANDLING_TIME_MILLIS).start();
		}

		Thread.sleep(N_MESSAGES / N_CONSUMERS * MSG_HANDLING_TIME_MILLIS + 1000);

	}

}
