package consumerProducer;

public class ConsumerProducerPattern {

	public static void main(String[] args) {
		Producer producer=new Producer();
		Consumer consumer=new Consumer();
		
		producer.start();
		consumer.start();

	}

	static class Producer extends Thread{

		private Consumer consumer;
		private String[] messages;
		@Override
		public void run() {
			producerMessage();
			for(String mes:messages){
				try {
					//consumer.recieve(mes);
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		private void producerMessage(){
			messages=new String[]{
					"bababa",
					"dinozavyr",
					"FMI",
					"drugo",
					"end"
			};
		}
	}
	static class Consumer extends Thread{

		private Producer producer;
		private boolean flag=false;
		@Override
		public void run() {
			while(flag){
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
		}}
	
	
	static class Message{
		private String message;

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}
		
	}
}
