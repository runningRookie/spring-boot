package contacts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/")
public class ContactController {

    @Autowired
    private ContactRepository contactRepository;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public int save(@RequestBody Contact contact) {
        contactRepository.save(contact);
        return 1;
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<Contact> findAll() {
        return contactRepository.findAll();
    }
}
