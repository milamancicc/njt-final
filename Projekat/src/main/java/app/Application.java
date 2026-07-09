///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package app;
//
//import app.config.AppConfig;
//import app.dto.SportistaDto;
//import app.dto.SportistaVezbaDto;
//import app.dto.TrenerDto;
//import app.service.SportistaService;
//import app.service.SportistaVezbaService;
//import app.service.TrenerService;
//import java.util.List;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//import org.springframework.stereotype.Component;
//
///**
// *
// * @author PC
// */
//@Component
//public class Application {
//    private final SportistaService sportistaService;
//    private final TrenerService trenerService;
//    private final SportistaVezbaService sportistaVezbaService;
//    
//
//    @Autowired
//    public Application(@Qualifier(value = "sportista-service")SportistaService sportistaService,
//            @Qualifier(value = "trener-service") TrenerService trenerService,
//            @Qualifier(value = "sportistaVezbe-service") SportistaVezbaService sportistaVezbaService) {
//        this.sportistaService = sportistaService;
//        this.trenerService = trenerService;
//        this.sportistaVezbaService = sportistaVezbaService;
//    }
//    
//    
//    public static void main(String[] args) {
//        ApplicationContext container = new AnnotationConfigApplicationContext(AppConfig.class);
//        Application app = container.getBean(Application.class);
//                
//    }
//    
//    public void saveSportista(SportistaDto dto){
//        sportistaService.save(dto);
//    }
//    
//    public void deleteSportista(SportistaDto dto){
//        sportistaService.delete(dto);
//    }
//    
//    public List<SportistaDto> findAllByTrener(String trenerId){
//        return sportistaService.findAllByTrener(trenerId);
//    }
//    public SportistaDto findSportistaById(String id){
//        return sportistaService.findById(id);
//    }
//    public TrenerDto findTrenerById(String id){
//        return trenerService.findById(id);
//    }
//    
//    public void saveSportistaVezba(SportistaVezbaDto dto){
//        sportistaVezbaService.save(dto);
//    }
//    public void deleteSportistaVezba(SportistaVezbaDto dto){
//        sportistaVezbaService.delete(dto);
//    }
//    public void updateSportistaVezba(SportistaVezbaDto dto){
//        sportistaVezbaService.update(dto);
//    }
//    public List<SportistaVezbaDto> findAllSportistaVezbaBySportista(String sportistaId){
//        return sportistaVezbaService.findAllBySportista(sportistaId);
//    }
//    
//}
