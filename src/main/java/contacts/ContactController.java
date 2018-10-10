package contacts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/")
public class ContactController {

    @Autowired
    private ContactRepository contactRepository;

    /**
     * 获取所有联系人
     *
     * @param model
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public String home(Map<String, Object> model) {
        List<Contact> contacts = contactRepository.findAll();
        model.put("contacts", contacts);
        return "home";
    }

    /**
     * 保存联系人
     *
     * @param contact
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    public String submit(Contact contact) {
        contactRepository.save(contact);
        return "redirect:/";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/save")
    @ResponseBody
    public int save(@RequestBody Contact contact) {
        contactRepository.save(contact);
        return 1;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/findAll")
    @ResponseBody
    public List<Contact> findAll() {
        return contactRepository.findAll();
    }
}
