package telran.messages.model;

import telran.chat.model.Message;

public interface MessageBox {

	void post(Message message);

	Message get();

}
