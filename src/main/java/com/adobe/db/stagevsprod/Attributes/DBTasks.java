package com.adobe.db.stagevsprod.Attributes;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import com.adobe.autotest.ws.utils.Logger;
import com.adobe.db.stagevsprod.Utils.Base64encodedecodeUtils;
import com.adobe.db.stagevsprod.Utils.DBUtil;
import com.adobe.db.stagevsprod.Utils.XMLUtil;
import com.adobe.db.stagevsprod.Validator.Validations;
import com.adobe.db.stagevsprod.vo.AdobeLicenseDocument;
import com.adobe.db.stagevsprod.vo.LicensableEntityData;
import com.adobe.db.stagevsprod.vo.SLConfig;

public class DBTasks {

	DBUtil db = new DBUtil();
	Validations validator = new Validations();
	Base64encodedecodeUtils base64 = new Base64encodedecodeUtils();

	/**
	 * This Class deals with getting data 
	 * for ScenarioFile Table in DB
	 * for both Stage and Prod,
	 * then send it to Comparator 
	 * class to compare the result
	 * 
	 * @param productName
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<String> scenarioFileUtils(String productName) throws SQLException{
		Logger.add("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< Start of SCENARIOSTABLE query for "+productName+" >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

		ArrayList<String> stageScenarioFile = new ArrayList<String>();
		ArrayList<String> prodScenarioFile = new ArrayList<String>();
		ArrayList<String> OutputResult = new ArrayList<String>();

		stageScenarioFile = db.scenarioFile("Stage", productName);
		prodScenarioFile = db.scenarioFile("Prod", productName);

		OutputResult = validator.compareResultFromStageVsProd(stageScenarioFile, prodScenarioFile, "SCENARIOSTABLE", productName);

		Logger.add("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< End of SCENARIOSTABLE >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");		
		return OutputResult;
	}

	/**
	 * This Class deals with getting data 
	 * for Aul Table in DB
	 * for both Stage and Prod,
	 * then send it to Comparator 
	 * class to compare the result
	 * 
	 * @param productName
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<String> aulFileUtils(String productName) throws SQLException{

		Logger.add("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< Start of AULTABLE query for "+productName+" >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

		ArrayList<String> stageAULFile = new ArrayList<String>();
		ArrayList<String> prodAULFile = new ArrayList<String>();
		ArrayList<String> OutputResult = new ArrayList<String>();
		
		stageAULFile = db.aulFile("Stage", productName);
		prodAULFile = db.aulFile("Prod", productName);
		
		OutputResult = validator.compareResultFromStageVsProd(stageAULFile, prodAULFile, "AULTABLE", productName);
		
		Logger.add("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< End of AULTABLE >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		return validator.failureList;
	}

	/**
	 * This Class deals with getting data 
	 * for PID info Table in DB
	 * for both Stage and Prod,
	 * then send it to Comparator 
	 * class to compare the result
	 * 
	 * @param productName
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<String> pidInfoUtils(String productName) throws SQLException{

		Logger.add("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< Start of PIDINFOTABLE query for "+productName+" >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

		ArrayList<String> stagePIDInfo = new ArrayList<String>();
		ArrayList<String> prodPIDInfo = new ArrayList<String>();
		ArrayList<String> outputResult = new ArrayList<String>();

		stagePIDInfo = db.pidInfoCheck("Stage", productName);
		prodPIDInfo = db.pidInfoCheck("Prod", productName);

		outputResult = validator.compareResultFromStageVsProd(stagePIDInfo, prodPIDInfo, "PIDINFOTABLE", productName);

		Logger.add("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< End of PIDINFOTABLE >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		return outputResult;
	}

	/**
	 * This Class deals with getting data 
	 * for LEID Table in DB
	 * for both Stage and Prod,
	 * then send it to Comparator 
	 * class to compare the result
	 * 
	 * @param productName
	 * @return
	 * @throws SQLException
	 */
	@SuppressWarnings("unchecked")
	public ArrayList<String> leidUtils(String productName) throws SQLException{

		Logger.add("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< Start of LEIDTABLE query for "+productName+" >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

		ArrayList<String> stageLEIDs = new ArrayList<String>();
		ArrayList<String> prodLEIDs = new ArrayList<String>();
		ArrayList<String> OutputResult = new ArrayList<String>();

		stageLEIDs = db.leidCheck("Stage", productName);
		prodLEIDs = db.leidCheck("Prod", productName);

		OutputResult = validator.compareResultFromStageVsProd(stageLEIDs, prodLEIDs, "LEIDTABLE", productName);

		Logger.add("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< End of LEIDTABLE >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		return OutputResult;
	}

	/**
	 * This Class deals with getting data 
	 * for LEID Dominance Table in DB
	 * for both Stage and Prod,
	 * then send it to Comparator 
	 * class to compare the result
	 * 
	 * @param productName
	 * @return
	 * @throws SQLException
	 */
	@SuppressWarnings("unchecked")
	public ArrayList<String> leidDominanceUtils(String productName) throws SQLException{

		Logger.add("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< Start of LEIDDOMIANCETABLE query for "+productName+" >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

		ArrayList<String> stageLEIDDoimance = new ArrayList<String>();
		ArrayList<String> prodLEIDDoimance = new ArrayList<String>();
		ArrayList<String> outputResult = new ArrayList<String>();

		stageLEIDDoimance = db.leidDominanceCheck("Stage", productName);
		prodLEIDDoimance = db.leidDominanceCheck("Prod", productName);

		outputResult = validator.compareResultFromStageVsProd(stageLEIDDoimance, prodLEIDDoimance, "LEIDDOMIANCETABLE", productName);

		Logger.add("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< End of LEIDDOMIANCETABLE >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		return outputResult;
	}

	/*public ArrayList<String> leidInSlConfigUtils(String productName) throws SQLException{

		Logger.add("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< Start of LEIDINSLCONFIGTABLE query for "+productName+" >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

		ArrayList<String> stageLEIDInSLconfig = new ArrayList<String>();
		ArrayList<String> prodLEIDInSLconfig = new ArrayList<String>();
		ArrayList<String> outputResult = new ArrayList<String>();

		stageLEIDInSLconfig = db.leidInSlConfigFile("Stage", productName);
		prodLEIDInSLconfig = db.leidInSlConfigFile("Prod", productName);

		outputResult = validator.compareResultFromStageVsProd(stageLEIDInSLconfig, prodLEIDInSLconfig, "LEIDINSLCONFIGTABLE", productName);

		Logger.add("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< End of LEIDINSLCONFIGTABLE >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		return outputResult;
	}*/

	/**
	 * This Class deals with getting data 
	 * for SLConfig Table in DB
	 * for both Stage and Prod,
	 * then send it to Comparator 
	 * class to compare the result
	 * 
	 * @param productName
	 * @return
	 * @throws Exception
	 */
	public ArrayList<String> slConfigUtils(String productName) throws Exception {

		Logger.add("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< Start of SLCONFIGFEATURECHECK query for "+productName+" >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

		ArrayList<String> stageSLConfigFile = new ArrayList<String>();
		ArrayList<String> prodSLonfigFile = new ArrayList<String>();
		LinkedHashMap<String, AdobeLicenseDocument> data = new LinkedHashMap<String, AdobeLicenseDocument>();
		ArrayList<String> outputResult = new ArrayList<String>();


		stageSLConfigFile = db.slConfigFile("Stage", productName);
		prodSLonfigFile = db.slConfigFile("Prod", productName);

		for (int i = 0; i < stageSLConfigFile.size(); i++) {

			String stageLeid = stageSLConfigFile.get(i).split(" | ")[0].trim();
			String stageSlconfig = stageSLConfigFile.get(i).split(" | ")[2].trim();

			for (int j = 0; j < prodSLonfigFile.size(); j++) {

				String prodLeid = prodSLonfigFile.get(j).split(" | ")[0].trim();
				String prodSlconfig = prodSLonfigFile.get(j).split(" | ")[2].trim();

				if (stageLeid.equalsIgnoreCase(prodLeid)) {

					String FirstLevelDecode_Stage = base64.decode(stageSlconfig);
					SLConfig Stage_ResponseObject = null;
					try {
						Stage_ResponseObject = XMLUtil.getSLConfigResponseObject(FirstLevelDecode_Stage);
					} catch (Exception e) {
						Logger.add("1. Unable to parse the xml for the LEID: " + stageLeid);
						System.err.println("1. Unable to parse the xml for the LEID: " + stageLeid);
						continue;
					}
					ArrayList<String> stage_licensableentityidandsldata = xmlSLconfigManipulation(Stage_ResponseObject);

					for (int k = 0; k < stage_licensableentityidandsldata.size(); k++) {

						String stagesldata = stage_licensableentityidandsldata.get(k).split(" | ")[2];
						String SecondLevelDecode_Stage = base64.decode(stagesldata);
						AdobeLicenseDocument Stage_responseObject = null;
						try {
							Stage_responseObject = XMLUtil.getActivationResponseObject(SecondLevelDecode_Stage);
						} catch (Exception e) {
							Logger.add("2. Unable to parse the xml for the LEID: " + stageLeid);
							System.err.println("2. Unable to parse the xml for the LEID: " + stageLeid);
							continue;
						}
						data.put(stageLeid + " | " + "Stage", Stage_responseObject);

					}

					String FirstLevelDecode_Prod = base64.decode(prodSlconfig);
					SLConfig Prod_ResponseObject = XMLUtil.getSLConfigResponseObject(FirstLevelDecode_Prod);
					ArrayList<String> Prod_licensableentityidandsldata = xmlSLconfigManipulation(Prod_ResponseObject);

					for (int k = 0; k < Prod_licensableentityidandsldata.size(); k++) {

						String prodsldata = Prod_licensableentityidandsldata.get(k).split(" | ")[2];
						String SecondLevelDecode_Prod = base64.decode(prodsldata);
						AdobeLicenseDocument Prod_responseObject = null;
						try {
							Prod_responseObject = XMLUtil.getActivationResponseObject(SecondLevelDecode_Prod);
						} catch (Exception e) {
							Logger.add("3. Unable to parse the xml for the LEID: " + prodLeid);
							System.err.println("3. Unable to parse the xml for the LEID: " + prodLeid);
							continue;
						}	
						data.put(prodLeid + " | " + "Prod", Prod_responseObject);
					}
					break;

				} else {
					if (j == prodSLonfigFile.size()-1) {
						validator.failureList.add("SLCONFIGFEATURECHECK : Extra Stage Data is available as compared with Prod Data for Product - " + productName + " : " + stageLeid);
					}
				}
			}
		}

		for (int k = 0; k < prodSLonfigFile.size(); k++) {

			String prodLeid1 = prodSLonfigFile.get(k).split(" | ")[0].trim();

			for (int l = 0; l < stageSLConfigFile.size(); l++) {

				String stageLeid1 = stageSLConfigFile.get(l).split(" | ")[0].trim();

				if (prodLeid1.equalsIgnoreCase(stageLeid1)) {
					//do nothing
					//System.out.println(ProdLeid1 + " :Prod LEID === Stage LEID : " + StageLeid1);
					break;
				} else {
					if (l == stageSLConfigFile.size()-1) {
						validator.failureList.add("SLCONFIGFEATURECHECK : Extra Prod Data is available as compared with Stage Data for Product - " + productName + " : " + prodLeid1);
					}
				}
			}
		}
		outputResult = validator.compareResultFromStageVsProdActivationResponse(data, "SLCONFIGFEATURECHECK", productName);
		Logger.add("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< End of SLCONFIGFEATURECHECK >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		return outputResult;
	}

	/**
	 * @param stageResponseObject
	 * @return
	 */
	public ArrayList<String> xmlSLconfigManipulation(SLConfig stageResponseObject){

		ArrayList<LicensableEntityData> response = stageResponseObject.LicenseInfo.LicensableEntityData;
		ArrayList<String> encryrequest = new ArrayList<String>();
		for (int i = 0; i < response.size(); i++) {

			String slrdata = response.get(i).ActivationGraceSLR.SLRData;
			String licensableentityid = response.get(i).LicensableEntityID;
			encryrequest.add(licensableentityid + " | " + slrdata);
		}
		return encryrequest;
	}
}
