package cz.fku.controller;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.core.util.StatusPrinter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Filip on 04.11.2016.
 *
 * Maps to <protocol>://<hostname>:<port>/<context-root>/<servlet-mapping><url-pattern>/testEcho/{testId}
 * e.g.: http://localhost:7001/app/api/testEcho/1
 */
@RestController
@RequestMapping("/testEcho")
public class TestController {
    final private Logger logger = LoggerFactory.getLogger(TestController.class);

    @RequestMapping(value = "/{testId}", method = RequestMethod.GET)
    public String test(@PathVariable String testId) {
        testLogger();
//      return value is automatically bound to the web response body
        return testId;
    }

//  logback info:  http://logback.qos.ch/manual/architecture.html
    private void testLogger() {
        logger.info("----------------FKU----------------");
        // print internal state
        LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
        StatusPrinter.print(lc);
    }
}
