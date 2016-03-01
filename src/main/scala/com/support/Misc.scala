 // println("-----> All Businesses")
        // println(RouteHandlerService.processControllerBBDS_all())
        // println("-----> Businesses In Skerries")
        // println(RouteHandlerService.processControllerBBDS_town("Skerries"))
        // println("-----> Businesses In Dublin")
        // println(RouteHandlerService.processControllerBBDS_county("Dublin"))
        // println("-----> Businesses In Munster")
        // println(RouteHandlerService.processControllerBBDS_region("Munster"))
        // println("----------")
        // println("----------")
        // println("----------")
        // println("----------")
        
        // println("----------")
        // println("-----> Get GTS")
        // println(RouteHandlerService.processControllerGTS_lat_lng("115a Sarsfield Park Lucan Co Dublin"))
        

        // println("----------")
        // println("-----> Get GTS")
        // println(RouteHandlerService.processControllerGTS_lat_lng("115a Sarsfield Park Lucan Co Dublin"))
        
        
        
        // def getGeoCords(address: String): String = { RouteHandlerService.processControllerGTS_lat_lng(address) }
        // val geoCordsListMaster            = businessAddresses.map(getGeoCords(_))
        // println("!"+ geoCordsListMaster)
        // val geoCordsListMasterJson = geoCordsListMaster.toString
        // println("*"+ geoCordsListMasterJson)
        // // val geoCordsListMasterJson = write(geoCordsListMaster)
        // // println("*"+ geoCordsListMasterJson)
        // val geoCordsListMasterJValue = parse(write(geoCordsListMasterJson))
        // println("**"+ geoCordsListMasterJValue)
        
        // val geoCordsListMasterJValue = parse(geoCordsListMasterJson)
        // // // println("------------------------------------------")
        
        // println("***"+ geoCordsListMasterJValue)
        
        // val latList             = for { JObject("lat", JString(lat)) <- geoCordsListMasterJValue } yield lat
        // println(latList)
        
        // val geoCordsListMasterJson = parse(geoCordsListMaster)
        // geoCordsListMasterJson
        //val lastList            = for { JField("lat", JString(lat)) <- geoCordsListMasterJson } yield lat
       
        // val latList              = ProcessControllerHelper.getLatitude(write(geoCords))
        // println("------------------------------------------")
        // println(latList)
        
        
        
        
        //--------------------------
        
        ///def getGeoCords(address: String): String = { RouteHandlerService.processControllerGTS_lat(address) }
        // val geoCordsListMaster            = businessAddresses.map(getGeoCords(_))
        // println("String: "+geoCordsListMaster.isInstanceOf[String])
        // println("List: "+geoCordsListMaster.isInstanceOf[List[Any]])
        // // println("-"+geoCordsListMaster)
        
        
        // val geoCordsListMasterJson = write(geoCordsListMaster)
        // println("String: "+geoCordsListMasterJson.isInstanceOf[String])
        // println("List: "+geoCordsListMasterJson.isInstanceOf[List[Any]])
        // // println("-"+geoCordsListMasterJson)
        
        // val geoCordsListMasterJValue = parse(geoCordsListMasterJson)
        // println("String: "+geoCordsListMasterJValue.isInstanceOf[String])
        // println("List: "+geoCordsListMasterJValue.isInstanceOf[List[Any]])
        // println("-"+geoCordsListMasterJValue)
        
        
        
        // // val pattern = "[-0-9.]".r
        // // val matches = pattern.findAllIn(geoCordsListMasterJValue)
        // // println(matches)
        // // val x = for (lat <- matches)yield lat
        // // println(x)
        
        
        // // val x = geoCordsListMaster.mkString
        // // println("*"+x)
        
        // // val geoCordsListMasterJValue = parse(x)
        // // println("--"+geoCordsListMasterJValue)
        
        // // val lats   =  for { JField("lat", JString(lat)) <- geoCordsListMasterJValue } yield lat
        // // println(lats)