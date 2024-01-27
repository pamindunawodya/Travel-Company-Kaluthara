package lk.ijse.guideservice.api;
import lk.ijse.guideservice.dto.GuideDTO;
import lk.ijse.guideservice.service.GuideService;
import lk.ijse.guideservice.util.ResponseUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.ArrayList;


@RestController
@RequestMapping("api/guide")
@CrossOrigin
public class GuideController {

    @Autowired
    GuideService guideService;

    @Autowired
    ModelMapper mapper;


    @PostMapping
    public ResponseUtil saveGuide(@RequestParam("id")Long id,
                                  @RequestParam("guidename")String guidename,
                                  @RequestParam("guideaddress")String guideaddress,
                                  @RequestParam("age")int age,
                                  @RequestParam("gender")String gender,
                                  @RequestParam("contactnumber")String contactnumber,
                                  @RequestParam("guideimage") MultipartFile guideimage,
                                  @RequestParam("guide_nic_image")MultipartFile guide_nic_image,
                                  @RequestParam("exeprience")String exeprince,
                                  @RequestParam("man_day_value")double man_day_value
                           )throws IOException{
        GuideDTO guide=new GuideDTO(id,guidename,guideaddress,age,gender,contactnumber,guideimage.getBytes(),guide_nic_image.getBytes(),exeprince,man_day_value);
        guideService.addGuide(guide);
        return new ResponseUtil("200","New Guide Add Sucessfull",null);
    }

    @PutMapping
    public  ResponseUtil updateGuide(@RequestParam("id")Long id,
                                     @RequestParam("guidename")String guidename,
                                     @RequestParam("guideaddress")String guideaddress,
                                     @RequestParam("age")int age,
                                     @RequestParam("gender")String gender,
                                     @RequestParam("contactnumber")String contactnumber,
                                     @RequestParam("guideimage") MultipartFile guideimage,
                                     @RequestParam("guide_nic_image")MultipartFile guide_nic_image,
                                     @RequestParam("exeprience")String exeprince,
                                     @RequestParam("man_day_value")double man_day_value)throws IOException{


        GuideDTO guideDTO = new GuideDTO(id,
                guidename,
                guideaddress,
                age,
                gender,
                contactnumber,
                guideimage.getBytes(),
                guide_nic_image.getBytes(),
                exeprince,
                man_day_value);

        guideService.updateGuide(guideDTO);
        return new ResponseUtil("200"," Guide Upadte Sucessfull",null);
    }

    @DeleteMapping(params = "id")
    public ResponseUtil deleteVehicle(@RequestParam Long id){
        guideService.deleteGuide(id);
        return new ResponseUtil("200",id+"Deleted Sucessfull",null);
    }

    @GetMapping(value = "/search",params = "guidename",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil searchGuideByName(@RequestParam String guidename){
        ArrayList<GuideDTO> guideDTOArrayList=guideService.searchGuideByName(guidename);
        return new ResponseUtil("200",guidename+"Searching Name Sucessfull",guideDTOArrayList);
    }

    @GetMapping
    public ResponseUtil getAllGuides(){
        ArrayList<GuideDTO>getAll=guideService.getAllGuides();
        return new ResponseUtil("200","show all guides",getAll);
    }
}
