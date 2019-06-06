package com.lambdaschool.bunnies.controller;

        import com.lambdaschool.bunnies.BunniesApplication;
        import com.lambdaschool.bunnies.exception.ResourceNotFoundException;
        import com.lambdaschool.bunnies.model.Bunny;
        import org.slf4j.Logger;
        import org.slf4j.LoggerFactory;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.http.HttpStatus;
        import org.springframework.http.ResponseEntity;
        import org.springframework.web.bind.annotation.GetMapping;
        import org.springframework.web.bind.annotation.PathVariable;
        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.RestController;
        import org.springframework.web.servlet.ModelAndView;

        import javax.servlet.http.HttpServletRequest;
        import java.util.ArrayList;

@RestController
@RequestMapping("/data")
public class BunniesController
{
    private static final Logger logger = LoggerFactory.getLogger(BunniesController.class);


    //localhost:2019/data/allbunnies
    @GetMapping(value = "/allbunnies",
                produces = {"application/json"})
    public ResponseEntity<?> getAllBunnies(HttpServletRequest request)
    {
        logger.info(request.getRequestURI() + " accessed");

        BunniesApplication.ourBunnyList.bunnyList.sort((e1, e2) -> e1.getName().compareToIgnoreCase(e2.getName()));
        return new ResponseEntity<>(BunniesApplication.ourBunnyList.bunnyList, HttpStatus.OK);
    }


    // localhost:2019/data/bunny/2
    @GetMapping(value = "/bunny/{id}",
                produces = {"application/json"})
    public ResponseEntity<?> getBunnyDetail(HttpServletRequest request,
                                            @PathVariable
                                                    long id) throws ResourceNotFoundException
    {
        logger.trace(request.getRequestURI() + " accessed");

        Bunny rtnBunny;
        if (BunniesApplication.ourBunnyList.findBunny(b -> (b.getId() == id)) == null)
        {
            throw new ResourceNotFoundException("bunny with id " + id + " not found");
        } else
        {
            rtnBunny = BunniesApplication.ourBunnyList.findBunny(b -> (b.getId() == id));
        }
        return new ResponseEntity<>(rtnBunny, HttpStatus.OK);
    }

    // localhost:2019/data/bunnytable
    @GetMapping(value = "/bunnytable")
    public ModelAndView displayBunnyTable(HttpServletRequest request)
    {
        logger.trace(request.getRequestURI() + " accessed");

        ModelAndView mav = new ModelAndView();
        mav.setViewName("bunnies");
        mav.addObject("bunnyList", BunniesApplication.ourBunnyList.bunnyList);

        return mav;
    }
}
