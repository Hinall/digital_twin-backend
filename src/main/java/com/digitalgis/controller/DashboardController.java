package com.digitalgis.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import com.digitalgis.service.DashboardService;
import com.digitalgis.utils.CustomMessages;
import org.springframework.web.multipart.MultipartFile;
import springfox.documentation.annotations.ApiIgnore;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.*;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import javax.imageio.ImageIO; 
import java.awt.image.BufferedImage;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.Files;
import java.io.IOException;
import java.awt.image.BufferedImage; 
import java.io.ByteArrayInputStream; 
import java.io.ByteArrayOutputStream; 

@ApiIgnore
@RestController
@RequestMapping(value = "/dashboard")
public class DashboardController {

	private static final Logger logger = LoggerFactory.getLogger(DashboardController.class);
	
	@Autowired
	private DashboardService dashService;
	
	@ApiIgnore
	@RequestMapping(value = "/add_update_street_light_data", method = RequestMethod.POST)
	public ResponseEntity<?> addUpdateStreetLightData( @RequestBody String json,HttpServletRequest request ) {
		try {
			String result = dashService.addUpdateStreetLightData(json);
			return ResponseEntity.ok(result);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.ok(CustomMessages.getMessage(CustomMessages.RESPONSE_MESSAGE_500));
		}
	}
	
	@ApiIgnore
	@RequestMapping(value = "/delete_street_light_data", method = RequestMethod.POST)
	public ResponseEntity<?> deleteStreetLightData( @RequestBody String json,HttpServletRequest request ) {
		try {
			String result = dashService.deleteStreetLightData(json);
			return ResponseEntity.ok(result);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.ok(CustomMessages.getMessage(CustomMessages.RESPONSE_MESSAGE_500));
		}
	}
	
	@ApiIgnore
	@RequestMapping(value = "/get_point_layers", method = RequestMethod.GET)
	public ResponseEntity<?> getPointLayer( HttpServletRequest request ) {
		try {
			String result = dashService.getPointLayer();
			return ResponseEntity.ok(result);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.ok(CustomMessages.getMessage(CustomMessages.RESPONSE_MESSAGE_500));
		}
	}

	
	@ApiIgnore
	@RequestMapping(value = "/search_layer", method = RequestMethod.POST)
	public ResponseEntity<?> searchLayer(@RequestBody String json, HttpServletRequest request ) {
		try {
			String result = dashService.searchLayer(json);
			return ResponseEntity.ok(result);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.ok(CustomMessages.getMessage(CustomMessages.RESPONSE_MESSAGE_500));
		}
	}
	
	@ApiIgnore
	@RequestMapping(value = "/get_role_by_userid", method = RequestMethod.POST)
	public ResponseEntity<?> getRoleByUserId(@RequestBody String json, HttpServletRequest request ) {
		try {
			String result = dashService.getRoleByUserId(json);
			return ResponseEntity.ok(result);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.ok(CustomMessages.getMessage(CustomMessages.RESPONSE_MESSAGE_500));
		}
	}
	
	
	@ApiIgnore
	@RequestMapping(value = "/get_role_list", method = RequestMethod.GET)
	public ResponseEntity<?> getRoleList(HttpServletRequest request ) {
		try {
			String result = dashService.getRoleList();
			return ResponseEntity.ok(result);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.ok(CustomMessages.getMessage(CustomMessages.RESPONSE_MESSAGE_500));
		}
	}
	
	
	@ApiIgnore
	@RequestMapping(value = "/announcement_management", method = RequestMethod.POST)
	public ResponseEntity<?> getAnnouncementDetails(@RequestBody String json, HttpServletRequest request ) {
		try {
			String result = dashService.getAnnouncementDetails(json);
			return ResponseEntity.ok(result);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.ok(CustomMessages.getMessage(CustomMessages.RESPONSE_MESSAGE_500));
		}
	}
	
	  @RequestMapping(value = "/upload_files", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	    public ResponseEntity<?> addfile(
	            @RequestParam(value = "images", required = false) MultipartFile[] images,
	            @RequestParam(value = "documents", required = false) MultipartFile[] documents,
	            @RequestParam(value = "folderName", required = true) String folderName,
	            HttpServletRequest httpServletRequest,
	            HttpServletResponse httpServletResponse) {

	        String imageDirectory = "D:/Amnex/digital_twin-Angular/digital_twin_frontend/src/app/demo/project-management/images";
	        String documentDirectory = "D:/Amnex/digital_twin-Angular/digital_twin_frontend/src/app/demo/project-management/documents";

	        try {
	            // Process uploaded images
	            if (images != null) {
	                for (MultipartFile file : images) {
	                    saveFile(file, imageDirectory);
	                }
	            }

	            // Process uploaded documents
	            if (documents != null) {
	                for (MultipartFile file : documents) {
	                    saveFile(file, documentDirectory);
	                }
	            }

	        } catch (IOException e) {
	            e.printStackTrace();
	            return ResponseEntity.status(HttpServletResponse.SC_INTERNAL_SERVER_ERROR)
	                    .body("Error occurred while uploading files: " + e.getMessage());
	        }

	        return ResponseEntity.ok("Files uploaded successfully.");
	    }
//save
	    private void saveFile(MultipartFile file, String directory) throws IOException {
	        String filename = file.getOriginalFilename();
	        File dir = new File(directory);
	        if (!dir.exists()) {
	            dir.mkdirs();
	        }
	        Path filePath = Paths.get(directory, filename);
	        Files.delete(filePath);
	    }


	
	        @ApiIgnore
			@RequestMapping(path = "/get_files/{foldername}/{filename}", method = RequestMethod.GET)
	    public ResponseEntity<?> getFile(
	    		@PathVariable("filename") String fileName,@PathVariable("foldername") String folderName) throws IOException {
	        	String dir="";
	        	//if("images".equals(folderName)) {
	        		if(folderName.equals("images")) {
	        		dir="D:/Amnex/digital_twin-Angular/digital_twin_frontend/src/app/demo/project-management/images";
	        	}
	        	else {
	        		dir="D:/Amnex/digital_twin-Angular/digital_twin_frontend/src/app/demo/project-management/documents";

	        	}
	        	try {
	        		Path path = Paths.get(dir);
	        		 byte[] fileContent = fetchFile(fileName, dir);
	        	
	        		 return ResponseEntity.ok(fileContent);
	        } catch (IOException e) {
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error while fetching file: " + e.getMessage());
	        }        	
	    }
//			fetch   
		    private byte[] fetchFile(String fileName, String directory) throws IOException {
		   
		    	Path path = Paths.get(directory + "/" +  fileName);
	            if (Files.exists(path)) {
	            	return Files.readAllBytes(path);
	            } else {
	                throw new IOException("File not found: " + fileName);
	            }
	           
		    }
	


	        @DeleteMapping("/delete_files/{foldername}/{filename}")
	        public ResponseEntity<?> deleteSpecifiedFiles(
	                @PathVariable("filename") String fileName,
	                @PathVariable("foldername") String folderName) {

	            String dir;
	            if ("images".equals(folderName)) {
	                dir = "D:/Amnex/digital_twin-Angular/digital_twin_frontend/src/app/demo/project-management/images";
	            } else {
	                dir = "D:/Amnex/digital_twin-Angular/digital_twin_frontend/src/app/demo/project-management/documents";
	            }

	            try {
	                deleteFile(fileName, dir);
	                return ResponseEntity.status(HttpStatus.OK).body("File deleted successfully.");
	            } catch (IOException e) {
	                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error while deleting file: " + e.getMessage());
	            }
	        }
//	    	delete    
	 	   
	        private void deleteFile(String fileName, String dir) throws IOException {
	            Path path = Paths.get(dir, fileName);
	            Files.deleteIfExists(path);
	        }
	
	  @RequestMapping(value = "/crud_milestone_image", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	    public ResponseEntity<?> crudMilestoneImage(@RequestParam(value = "images", required = false) MultipartFile[] images,
	    											@RequestParam(value = "documents", required = false) MultipartFile[] documents,
	    											@RequestParam(value = "jsonData", required = true) String dataJson,
	    												HttpServletRequest httpServletRequest,
	    												HttpServletResponse httpServletResponse) {

	        // Initialize variables
	        JSONObject obj = null;//for holding input json data
	        String result = "";
	        StringBuilder imgFile = new StringBuilder();//to store name string

	        try {
	            // Parse the JSON data
	            obj = new JSONObject(dataJson);
	            HashSet<String> Img = new HashSet<String>();

	            // Process uploaded images
	            try {
	            	 if (images != null) {
	            		 for (MultipartFile file : images) { // Use a different variable name for clarity
	            	            String directory = "D:/Amnex/digital_twin-Angular/digital_twin_frontend/src/app/demo/project-management/images"; // Base directory where the file will be saved
	            	            String filename = file.getOriginalFilename();
	            	            File dir = new File(directory);
	            	            if (!dir.exists()) { dir.mkdirs();}	            	            	            	           
	            	            Path filePath = Paths.get(directory + File.separator + filename); // Construct the file path including the base directory	            	            	            	          
	            	            Files.copy(file.getInputStream(), filePath);  // Transfer the file to the specified directory
	            	        }}
	            		 if (documents != null) {
		            		 for (MultipartFile file_doc : documents) { // Use a different variable name for clarity
		            	            String directory_doc = "D:/Amnex/digital_twin-Angular/digital_twin_frontend/src/app/demo/project-management/documents"; // Base directory where the file will be saved
		            	            String filename_doc = file_doc.getOriginalFilename();
		            	            File dir_doc = new File(directory_doc);
		            	            if (!dir_doc.exists()) { dir_doc.mkdirs();}	            	            	            	           
		            	            Path filePath_doc = Paths.get(directory_doc + File.separator + filename_doc); // Construct the file path including the base directory	            	            	            	          
		            	            Files.copy(file_doc.getInputStream(),filePath_doc, StandardCopyOption.REPLACE_EXISTING);  // Transfer the file to the specified directory
		            	        }
	                  }
	          
	             } catch(IOException e){
	            	 e.printStackTrace();
	                 // Return error message
	                 return ResponseEntity.ok(CustomMessages.getMessage(CustomMessages.RESPONSE_MESSAGE_500));
	            
	           
	            }

	           

	            // Call the common service method to add feedback data
	            result = dashService.crudMilestoneImage(obj.toString());
	            // Return the result as a ResponseEntity
	            return ResponseEntity.ok(result);

	        } catch (Exception e) {
	            // Handle exceptions
	            e.printStackTrace();
	            // Return error message
	            return ResponseEntity.ok(CustomMessages.getMessage(CustomMessages.RESPONSE_MESSAGE_500));
	        }
	    }
	  
	
	
	
	@ApiIgnore
	@RequestMapping(value = "/milestone_status_list", method = RequestMethod.GET)
	public ResponseEntity<?> getStatusList( ) {
		try {
			String result = dashService.getStatusList();
			return ResponseEntity.ok(result);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.ok(CustomMessages.getMessage(CustomMessages.RESPONSE_MESSAGE_500));
		}
	}
	
	@ApiIgnore
	@RequestMapping(value = "/milestone_management", method = RequestMethod.POST)
	public ResponseEntity<?> getAllMilestoneDetails(@RequestBody String json, HttpServletRequest request ) {
		try {
			String result = dashService.getAllMilestoneDetails(json);
			return ResponseEntity.ok(result);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.ok(CustomMessages.getMessage(CustomMessages.RESPONSE_MESSAGE_500));
		}
	}
	
	
	@ApiIgnore
	@RequestMapping(value = "/project_management", method = RequestMethod.POST)
	public ResponseEntity<?> getAllProjectDetails(@RequestBody String json, HttpServletRequest request ) {
		try {
			String result = dashService.getAllProjectDetails(json);
			return ResponseEntity.ok(result);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.ok(CustomMessages.getMessage(CustomMessages.RESPONSE_MESSAGE_500));
		}
	}
	@ApiIgnore
	@RequestMapping(value = "/get_all_modules", method = RequestMethod.GET)
	public ResponseEntity<?> getAllModules( ) {
		try {
			String result = dashService.getAllModules();
			return ResponseEntity.ok(result);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.ok(CustomMessages.getMessage(CustomMessages.RESPONSE_MESSAGE_500));
		}
	}
	
	@ApiIgnore
	@RequestMapping(value = "/get_role_by_id", method = RequestMethod.GET)
	public ResponseEntity<?> getRoleById(@RequestBody String json, HttpServletRequest request ) {
		try {
			String result = dashService.getRoleById(json);
			return ResponseEntity.ok(result);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.ok(CustomMessages.getMessage(CustomMessages.RESPONSE_MESSAGE_500));
		}
	}
	
	
	
	
	
	// WRITE A USED API ABOVE THIS COMMENTS
	
	
	
	
	
	
//	@RequestMapping(value = "/get_ward_data", method = RequestMethod.POST, produces = "application/json")
//	public String getWardData(@RequestBody String json) throws JSONException {
//
//		// logger.info("-----------------get ward data API Called---------------");
//		try {
//
//			String alldata = dashService.getAllWardData(json);
//			return alldata;
//
//		} catch (Exception e) {
//
//			e.printStackTrace();
//			return CustomMessages.getMessage(CustomMessages.RESPONSE_MESSAGE_NO_JSON_400);
//
//		}
//	}
	
	@ApiIgnore
	@RequestMapping(value = "/get_draw_feature_data", method = RequestMethod.POST)
	public ResponseEntity<?> getDrawFeatureData(@RequestBody String json, HttpServletRequest request) {
		try {
			String result = dashService.getDrawFeatureData(json);
			return ResponseEntity.ok(result);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.ok(CustomMessages.getMessage(CustomMessages.RESPONSE_MESSAGE_500));
		}
	}
	
	@ApiIgnore
	@RequestMapping(value = "/get_lulc_count_details", method = RequestMethod.POST)
	public ResponseEntity<?> getLulcCountDetails(@RequestBody String json, HttpServletRequest request) {
		try {
			String result = dashService.getLulcCountDetails(json);
			return ResponseEntity.ok(result);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.ok(CustomMessages.getMessage(CustomMessages.RESPONSE_MESSAGE_500));
		}
	}

	@ApiIgnore
	@RequestMapping(value = "/get_change_analysis_data", method = RequestMethod.POST)
	public ResponseEntity<?> getChangeAnalysisData(@RequestBody String json, HttpServletRequest request) {
		try {
			String result = dashService.getChangeAnalysisData(json);
			return ResponseEntity.ok(result);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.ok(CustomMessages.getMessage(CustomMessages.RESPONSE_MESSAGE_500));
		}
	}
	
	
	@ApiIgnore
	@RequestMapping(value = "/get_retms_chart_data", method = RequestMethod.POST)
	public ResponseEntity<?> getRetmsChartData(@RequestBody String json, HttpServletRequest request) {
		try {
			String result = dashService.getRetmsChartData(json);
			return ResponseEntity.ok(result);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.ok(CustomMessages.getMessage(CustomMessages.RESPONSE_MESSAGE_500));
		}
	}
	
	@ApiIgnore
	@RequestMapping(value = "/get_retms_dashboard_grid_data", method = RequestMethod.POST)
	public ResponseEntity<?> getRetmsDashboardGridData(@RequestBody String json, HttpServletRequest request) {
		try {
			String result = dashService.getRetmsDashboardGridData(json);
			return ResponseEntity.ok(result);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.ok(CustomMessages.getMessage(CustomMessages.RESPONSE_MESSAGE_500));
		}
	}
	
}
