
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zensar.model.Value;

public class Demo {

	public static void main(String[] args) {

		JSONParser parser = new JSONParser();

		try (Reader reader = new FileReader("D:\\test.json")) {

			JSONArray jsonArray = (JSONArray) parser.parse(reader);
			// System.out.println(jsonObject);

			/*
			 * String name = (String) jsonObject.get("name");
			 * System.out.println(name);
			 * 
			 * long age = (Long) jsonObject.get("age"); System.out.println(age);
			 */
			// loop array
/*			JSONArray msg = (JSONArray) jsonObject.get("messages");
*/
/*			List<Object> list = Arrays.asList(msg);
 * 
*/
			

			ObjectMapper objectMapper = new ObjectMapper();

			Value[] value = objectMapper.readValue(jsonArray.toString(), Value[].class);
			
			List<Value> list = new ArrayList<Value>(Arrays.asList(value));
			
			for( int i=0; i< 5 ;i++)
			{
				System.out.println("id=" + list.get(i).getId());
				System.out.println("userid=" +list.get(i).getUserId() );
				System.out.println("title=" + list.get(i).getTitle());
				System.out.println("body=" + list.get(i).getBody());
			}
			
			
			/*for( Value v: value)
			{
				System.out.println("id=" + v.getId());
				System.out.println("userid=" +v.getUserId() );
				System.out.println("title=" + v.getTitle());
				System.out.println("body=" + v.getBody());
			}*/
			
			
			/*List<Object> list = Arrays.asList(value);
			
			for(int i=0; i< list.size();i++)
			{
				Value v = (Value) list.get(i);			
			
				System.out.println("id=" + v.getId());
				System.out.println("userid=" +v.getUserId() );
				System.out.println("title=" + v.getTitle());
				System.out.println("body=" + v.getBody());
			}*/
			
			
			
			
			/*for (int i = 0; i < 5; i++) {
				 JSONObject obj = (JSONObject) jsonArray.get(i);
				 
				 
				System.out.println("id=" + obj.get("id"));
				System.out.println("userid=" +obj.get("userId") );
				System.out.println("title=" + obj.get("title"));
				System.out.println("body=" + obj.get("body"));
				
				
			}*/
			
			
			
			/*
			 * Iterator<JSONObject> iterator = msg.iterator(); while
			 * (iterator.hasNext()) { System.out.println(iterator.next()); }
			 */

			
			
			
			/*
			 * for (int i=0;i<msg.size();i++) { Object obj = msg[i]; JSONObject
			 * jsonLineItem = (JSONObject) obj; Long id = (Long)
			 * jsonLineItem.get("id"); Long userid = (Long)
			 * jsonLineItem.get("userId"); String value = (String)
			 * jsonLineItem.get("title"); String body = (String)
			 * jsonLineItem.get("body"); System.out.println("id="+id);
			 * System.out.println("userid="+userid);
			 * System.out.println("title="+value);
			 * System.out.println("body="+body); System.out.println("");
			 * 
			 * 
			 * }
			 */

		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}

	}

}
