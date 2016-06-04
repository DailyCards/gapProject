package HackHack.HackHack;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.gap.main.TextGapper;

import HackHack.HackHack.some.Question;


/**
 * Root resource (exposed at "myresource" path)
 */
@Path("questions")
public class GetQuestions {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Question> getIt() {
    	Question question = new Question();
    	
    	TextGapper tg = new TextGapper();
    	ArrayList<Question> generatedQuestions = tg.getQuestions("This is Sparta. This is Krasi");
    	
//    	question.setText("Bobi e _____");
//    	question.setAnswer("mashina");
    	
        return generatedQuestions;
    }
}
