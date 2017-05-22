import java.io.FileInputStream;
import java.io.InputStream;

import opennlp.tools.namefind.NameFinderME;
import opennlp.tools.namefind.TokenNameFinderModel;
import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;
import opennlp.tools.util.Span;

public class openNLP{
    public static void main(String args[]) throws Exception{

        //Loading the tokenizer model
        InputStream inputStreamTokenizer = new
                FileInputStream("C:\\Users\\euj346\\Desktop\\workspace\\apachenlp\\open nlp models\\en-token.bin");
        TokenizerModel tokenModel = new TokenizerModel(inputStreamTokenizer);

        //Instantiating the TokenizerME class
        TokenizerME tokenizer = new TokenizerME(tokenModel);

        //Tokenizing the sentence in to a string array
        String sentence = "Neil A. Armstrong, the first man to walk on the moon, was born in Wapakoneta, Ohio,\n" +
                "on August 5, 1930. He began his NASA career in Ohio.\n" +
                "\n" +
                "After serving as a naval aviator from 1949 to 1952, Armstrong joined the National Advisory Committee for Aeronautics (NACA) in 1955. His first assignment was with the NACA Lewis Research Center (now NASA Glenn) in Cleveland. Over the next 17 years, he was an engineer, test pilot, astronaut and administrator for NACA and its successor agency, the National Aeronautics and Space Administration (NASA).\n" +
                "\n" +
                "As a research pilot at NASA's Flight Research Center, Edwards, Calif., he was a project pilot on many pioneering high speed aircraft, including the well known, 4000-mph X-15. He has flown over 200 different models of aircraft, including jets, rockets, helicopters and gliders.\n" +
                "\n" +
                "Armstrong transferred to astronaut status in 1962. He was assigned as command pilot for the Gemini 8 mission. Gemini 8 was launched on March 16, 1966, and Armstrong performed the first successful docking of two vehicles in space.\n" +
                "\n" +
                "As spacecraft commander for Apollo 11, the first manned lunar landing mission, Armstrong gained the distinction of being the first man to land a craft on the moon and first to step on its surface.\n" +
                "\n" +
                "Armstrong subsequently held the position of Deputy Associate Administrator for Aeronautics, NASA Headquarters, Washington, D.C. In this position, he was responsible for the coordination and management of overall NASA research and technology work related to aeronautics.\n" +
                "\n" +
                "He was Professor of Aerospace Engineering at the University of Cincinnati between 1971-1979. During the years 1982-1992, Armstrong was chairman of Computing Technologies for Aviation, Inc., Charlottesville, Va.\n" +
                "\n" +
                "He received a Bachelor of Science Degree in Aeronautical Engineering from Purdue University and a Master of Science in Aerospace Engineering from the University of Southern California. He holds honorary doctorates from a number of universities.\n" +
                "\n" +
                "Armstrong was a Fellow of the Society of Experimental Test Pilots and the Royal Aeronautical Society; Honorary Fellow of the American Institute of Aeronautics and Astronautics, and the International Astronautics Federation.\n" +
                "\n" +
                "He was a member of the National Academy of Engineering and the Academy of the Kingdom of Morocco. He served as a member of the National Commission on Space (1985-1986), as Vice-Chairman of the Presidential Commission on the Space Shuttle Challenger Accident (1986), and as Chairman of the Presidential Advisory Committee for the Peace Corps (1971-1973).\n" +
                "\n" +
                "Armstrong was decorated by 17 countries. He was the recipient of many special honors, including the Presidential Medal of Freedom; the Congressional Gold Medal; the Congressional Space Medal of Honor; the Explorers Club Medal; the Robert H. Goddard Memorial Trophy; the NASA Distinguished Service Medal; the Harmon International Aviation Trophy; the Royal Geographic Society's Gold Medal; the Federation Aeronautique Internationale's Gold Space Medal; the American Astronautical Society Flight Achievement Award; the Robert J. Collier Trophy; the AIAA Astronautics Award; the Octave Chanute Award; and the John J. Montgomery Award.\n" +
                "\n";
        String tokens[] = tokenizer.tokenize(sentence);

        //Loading the NER-person model
        InputStream inputStreamNameFinder = new
                FileInputStream("C:\\Users\\euj346\\Desktop\\workspace\\apachenlp\\open nlp models\\en-ner-person.bin");
        TokenNameFinderModel model = new TokenNameFinderModel(inputStreamNameFinder);

        //Instantiating the NameFinderME class
        NameFinderME nameFinder = new NameFinderME(model);

        //Finding the names in the sentence
        Span nameSpans[] = nameFinder.find(tokens);

        //Printing the names and their spans in a sentence
        for(Span s: nameSpans)
            System.out.println(s.toString()+"  "+tokens[s.getStart()]);
    }
}
