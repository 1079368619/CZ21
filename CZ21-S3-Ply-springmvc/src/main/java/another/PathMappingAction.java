package another;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PathMappingAction {

	@RequestMapping(value = "index1")
	public String index1() {
		return "index1";
	}
	
	@RequestMapping(path = "index2")
	public String index2() {
		return "index2";
	}
	
	@RequestMapping(path = "index3")
	public String index3() {
		return "index3";
	}
	
	@RequestMapping(path = "login", params = {"username", "password"})
	public String login() {
		return "login";
	}

	@RequestMapping(path = "cookie", headers = {"cookie", "Host=127.0.0.1"})
	public String cookie() {
		return "cookie";
	}
	
	@RequestMapping(path = "post1", method = RequestMethod.POST)
	public String post1() {
		return "post1";
	}
	

	@RequestMapping(path = "post2")
	public String post2() {
		return "post2";
	}

	@RequestMapping(path = "get1")
	public String get1() {
		return "get1";
	}

	@RequestMapping(path = "get2")
	public String get2() {
		return "get2";
	}
}
