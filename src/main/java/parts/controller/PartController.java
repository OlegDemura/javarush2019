package parts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import parts.model.Part;
import parts.service.PartService;

import javax.validation.Valid;
import java.util.List;

@Controller
public class PartController{

    @Autowired
    private PartService partService;

    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public String findAll(@RequestParam(defaultValue = "0", required = false, name = "page") int page, Model model){
        Pageable pageable = PageRequest.of(page, 10);
        Page<Part> parts = partService.listParts(pageable);
        model.addAttribute("partList", parts.getContent());
        model.addAttribute("maxPages", parts.getTotalPages());
        model.addAttribute("count", partService.countComp());
        return "index";
    }

    @RequestMapping(value = {"/sort/"}, method = RequestMethod.GET)
    public String findAllByParam(@RequestParam(defaultValue = "true", required = false, name = "parts") boolean parts,
                                 @RequestParam(defaultValue = "0", required = false, name = "page") int page, Model model){
        Pageable pageable = PageRequest.of(page, 10);
        Page<Part> partsList = partService.findAllByNessesery(parts, pageable);
        model.addAttribute("partList", partsList.getContent());
        model.addAttribute("nessesery",parts);
        model.addAttribute("maxPages", partsList.getTotalPages());
        model.addAttribute("count", partService.countComp());
        return "sort";
    }

    @RequestMapping(value = {"/search/"}, method = RequestMethod.GET)
    public String search(@RequestParam(defaultValue = "", required = false, name = "searchByName") String searchByName,
                         @RequestParam(defaultValue = "0", required = false, name = "page") int page, Model model){
        Pageable pageable = PageRequest.of(page,10);
        Page<Part> partsList = partService.findAllByDeviceName(searchByName,pageable);
        model.addAttribute("searchByName", searchByName);
        model.addAttribute("partList", partsList.getContent());
        model.addAttribute("maxPages", partsList.getTotalPages());
        model.addAttribute("count", partService.countComp());
        return "search";
    }


    @RequestMapping(value = "/part/{id}", method = RequestMethod.GET)
    public String findById(@PathVariable("id") Long id, Model model){
        model.addAttribute("part", this.partService.findById(id));
        return "part";
    }


    @RequestMapping(value = "/part/", method = RequestMethod.GET)
    public String create(Model model){
        Part part = new Part();
        model.addAttribute("part", part);
        return "part";
    }

    @RequestMapping(name = "/part/add", method = RequestMethod.POST)
    public String addPart(@Valid @ModelAttribute("part") Part part, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "part";
        }
        if (part.getId()==null){
            this.partService.addPart(part);
        }else {
            this.partService.updatePart(part);
        }
        return "redirect:/parts/";
    }

    @RequestMapping(value = "/remove/{id}", method = RequestMethod.GET)
    public String remove(@PathVariable("id") Long id){
        partService.removePart(id);
        return "redirect:/parts/";
    }

}