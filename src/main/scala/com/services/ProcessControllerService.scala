package com.services

import com.services.RouteHandlerService
import com.support.LoggingSupport
import com.support.ProcessControllerHelper

import scala.math.BigInt
import java.io.{IOException}
import scala.io.{Source}
import java.net.{URL, HttpURLConnection, SocketTimeoutException}

import net.liftweb.json._
import net.liftweb.json.Serialization.write
import java.util.Calendar
import net.liftweb.json.JsonDSL._

object ProcessControllerService {
    
    implicit val formats = DefaultFormats
    
    
    
    
    
    
    def main(args: Array[String]){
        
        //NOTE!!!! USe zip to merge the collections
        
        println("-----> Start Application")
        
        val businessListMasterJson = RouteHandlerService.processControllerBBDS_all()
        // val businessListMasterJson = RouteHandlerService.processControllerBBDS_town("Lusk")
        // val businessListMasterJson = RouteHandlerService.processControllerBBDS_region("Munster")
        //println("*"+ businessListMasterJson)
        val businessListMasterJValue = parse(businessListMasterJson)
        //println("**"+ businessListMasterJValue)
        
        //Filter values into Lists
        val businessNames       =  for { JField("name", JString(name)) <- businessListMasterJValue } yield name
        val businessAddresses   =  for { JField("address", JString(address)) <- businessListMasterJValue } yield address
        val businessPhones      =  for { JField("phone", JInt(phone)) <- businessListMasterJValue } yield phone
     
        println("----------")
        println("-----> Get GTS")
        
        def getGeoCords_lat(address: String): String = { RouteHandlerService.processControllerGTS_lat(address) }
        def getGeoCords_lng(address: String): String = { RouteHandlerService.processControllerGTS_lng(address) }
        def stripQuotes(x: String): String = {x.replace("\"","")}
        
        val geoCordsListMasterJson_lat = for(address <- businessAddresses) yield getGeoCords_lat(address)
        //println(geoCordsListMasterJson_lat)
        
        val geoCordsListMaster_lat = for(lat <- geoCordsListMasterJson_lat) yield stripQuotes(lat)
        //println(geoCordsListMaster_lat)
        
        val geoCordsListMasterJson_lng = for(address <- businessAddresses) yield getGeoCords_lng(address)
        //println(geoCordsListMasterJson_lng)
        
        val geoCordsListMaster_lng = for(lng <- geoCordsListMasterJson_lng) yield stripQuotes(lng)
        //println(geoCordsListMaster_lng)
        
        println("----------")
        println("-----> Combining Lists")
        
        //Zip Approach
        val combinedList1 = (businessNames, businessAddresses, businessPhones).zipped.toList
        //println(combinedList1)
        
        val combinedList2 = geoCordsListMaster_lat zip geoCordsListMaster_lng
        //println(combinedList2)
        
        
        // val combinedList3 = combinedList1 zip combinedList2
        val combinedList3 = (combinedList1, combinedList2).zipped.toList
        //println(combinedList3)
        
        // case class DataSet(b_name: String, b_address: String, b_phone: Int, b_lat: String, b_lng: String)
        // val min = List(businessNames, businessAddresses, businessPhones, geoCordsListMaster_lat, geoCordsListMaster_lng)
        // val dataSets = (0 until min) map { i => DataSet(businessNames(i), businessAddresses(i), businessPhones(i), geoCordsListMaster_lat(i), geoCordsListMaster_lng(i)) }
       
       
       println("----------")
       println("-----> Build Json Object")
       
       val dataSetJson = write(combinedList3)
       println(dataSetJson)
       
       
    }
    
    
}


               





