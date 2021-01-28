package another;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import another.bean.User;

@RestController
public class ParamMappingAction {

	@GetMapping("reg")
	public String reg(User user) {
		return user.toString();
	}
	
	@GetMapping("show/{uid}")
	public String show(@PathVariable("uid")int id) {
		return "id="+id;
	}

	@GetMapping("login")
	public String login(@RequestParam("uname")String uname,
			@RequestParam("upass")String pwd) {
		return uname+"=="+pwd;
	}
	
}
