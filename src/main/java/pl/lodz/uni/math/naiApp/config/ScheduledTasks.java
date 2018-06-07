package pl.lodz.uni.math.naiApp.config;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import pl.lodz.uni.math.naiApp.domain.Supplier;
import pl.lodz.uni.math.naiApp.service.OrderService;
import pl.lodz.uni.math.naiApp.service.ProductService;
import pl.lodz.uni.math.naiApp.service.SupplierService;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * Created by HP on 2018-06-07.
 */
@Component
public class ScheduledTasks {
    private static final String FILENAME = "C:\\Users\\HP\\Desktop\\testFile.txt";
    @Autowired
    private SupplierService supplierService;
    @Autowired
    private OrderService orderService;
    final static Logger logger = Logger.getLogger(ScheduledTasks.class);
    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

    @Scheduled(fixedRate = 60000)
    public void reportSuppliersStatus() {;
        saveToFile(supplierService.getAllSuppliers());
    }
    @Scheduled(fixedRate = 60000)
    public void reportProductsStatus() {
        logger.info("All orders count: "+ orderService.getOrderCount());
    }

    public void saveToFile(List<Supplier> supplierList) {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(FILENAME);
        } catch (IOException e) {
            logger.warn("Error open file");
        }
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.printf("Suppliers list on time: " + dateTimeFormatter.format(LocalDateTime.now())+System.lineSeparator());
        printWriter.print("Id:"+ " City:"+ " Company_name:" + " Contact_number:" +System.lineSeparator());
        for(Supplier s:supplierList){
            printWriter.print(s.getId()+" "+s.getCity()+ " "+ s.getCompany_name()+" " +s.getContact_number() +System.lineSeparator());
        }
        printWriter.close();
    }
}
