package d.oni.animal.context;

public interface ApplicationContextListener {

	  // 애플리케이션이 시작될 때 호출된다.
	  void contextInitialized();

	  // 애플리케이션이 종료될 떄 호출된다.
	  void contextDestroyed();
}
