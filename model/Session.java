package model;

public class Session {

	private static Session instance = null;
	private User user;
	
	public Session() {
	
	}
	
	/**
	 * Loga um usuario sess�o.
	 * 
	 * @param User user
	 * @return void
	 * */
	public void setUser(User user) {
		this.user = user;
	}
	
	/**
	 * Usuario que est� logado na sess�o.
	 * 
	 * @param 
	 * @return Usu�rio logado
	 * */
	public User getUser() {
		return this.user;
	}
	
	/**
	 * Inicia uma sess�o, se j� n�o exitir outra.
	 * 
	 * @param User user
	 * @return void
	 * */
	public static Session getInstance() {
		if (Session.instance == null) {
			instance = new Session();
		}
		return Session.instance;
	}
	
	/**
	 * Finaliza a sess�o ativa.
	 * 
	 * @param User user
	 * @return void
	 * */
	public void finalize() {
		if (Session.instance != null) {
			this.setUser(null);
			Session.instance = null;
		}
	}
}
