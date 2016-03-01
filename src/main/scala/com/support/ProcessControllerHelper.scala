package com.support

import com.support.LoggingSupport
import net.liftweb.json._
import net.liftweb.json.Serialization.write
import scala.io.{Source}

object ProcessControllerHelper {
    
    implicit val formats = DefaultFormats
    
    
    def encodeUrl(url: String) : String = { url.replace(" ", "+") }
    
    def getService(url: String) = scala.io.Source.fromURL(url).mkString
    
    def callRemoteService(queryParam: String, queryValue: String) : String = {
     
        val content = queryParam match {
                // case "town" => "Cunt Bags: " + queryValue
                // case "county" => "Gee Bags: " + queryValue
                case "all" => getService("http://localhost:8081/baseBusinesses/all/details")
                case "town" => getService("http://localhost:8081/baseBusinesses/all/details/towns/"+queryValue)
                case "county" => getService("http://localhost:8081/baseBusinesses/all/details/counties/"+queryValue)
                case "region" => getService("http://localhost:8081/baseBusinesses/all/details/regions/"+queryValue)
                case "gts" => getService("http://localhost:8082/geoTaggings/addresses/"+queryValue)
                case "gts_multi" => getService("http://localhost:8082/geoTaggings/addresses/"+queryValue)
                case "gts_lat" => getService("http://localhost:8082/geoTaggings/addresses/latitudes/"+queryValue)
                case "gts_lng" => getService("http://localhost:8082/geoTaggings/addresses/longitudes/"+queryValue)
                case _ => "No such Resource"
            }
     
     return content
    }
    
    
    def getRemoteService(serviceName: String, queryParam: String, queryValue: String): String = {
        println("-----> Logging")
        LoggingSupport.serviceRequestlog1(serviceName, s"$queryParam : $queryValue")
        
        //Matching Case statement
        val content = callRemoteService(queryParam, queryValue)
        return content
    }
    
    
}