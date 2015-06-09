interface LinuxStarter {
		List<String> commandList = null;
		ProcessBuilder builder = null;
		Process process = null;
		String result="";
	       int errCode = 0;
               String scriptFilePath = getOpmanagerScriptDir() + File.separator + "StartOpManagerServer.sh";
               String scriptFilePath = getOpmanagerScriptDir() + File.separator + "ShutDownOpManager.sh";
               String scriptFilePath = getOpmanagerScriptDir() +File.separator+ "backup" + File.separator + "RestoreDB.sh";
               filePath = getOpManagerBackupDir() + File.separator + "BackupDB.sh"; 

          //functions
          public static int startOpManager();
          public static int stopOpManager();
          public static int restoreConfigBackup(String opmBackupFile);
          public static int  invokeConfigBackup();
}


interface WindowsStarter extends LinuxStarter {
               String scriptFilePath = getOpmanagerScriptDir() + File.separator + "StartOpManagerServer.bat";
               String scriptFilePath = getOpmanagerScriptDir() + File.separator + "ShutDownOpManager.bat";
               String scriptFilePath = getOpmanagerScriptDir() +File.separator+ "backup" + File.separator + "RestoreDB.bat";
               filePath = getOpManagerBackupDir() + File.separator + "BackupDB.bat";
}

class LinuxOpmStarter implements LinuxStarter {
  
}

class WindowsOpmStarter implements WindowsStarter {

}

interface OpmStarterFactory {
  LinuxStarter getLinuxOpmStarter();
  WindowsStarter getWindowsOpmStarter();
}


class OpmStarter implements OpmStarterFactory {
  boolean linux = true;

  public void startOpm() {
  if (linux) {
    LinuxStarter obj = getLinuxOpmStarter();
    return obj.startopm();
  }
  else {
   WindowsStarter obj = getWindowsStarter();
   return obj.startopm();
  }
  }

  public void stopOpm() {
      if (linux) {
    LinuxStarter obj = getLinuxOpmStarter();
    return obj.startopm();
  }
  else {
   WindowsStarter obj = getWindowsStarter();
   return obj.startopm();
  }

  }

  public void invokebackup() {
      if (linux) {
    LinuxStarter obj = getLinuxOpmStarter();
    return obj.restore();
  }
  else {
   WindowsStarter obj = getWindowsStarter();
   return obj.restore();
  }

  }
  
  public void restorebackup() {
    if (linux) {
    LinuxStarter obj = getLinuxOpmStarter();
    return obj.restore();
    }
   else {
    WindowsStarter obj = getWindowsStarter();
    return obj.restore();
   }
  }

}
