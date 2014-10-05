param(
  [Parameter(Mandatory=$true,Position=1)]
  [string]$ComponentName
)

function BuildComponentDirectory()
{
  if (!(test-path .\$ComponentName))
  {
    New-Item -Path .\$ComponentName -type Directory
    Write-host "Component Directory Created"
  }
}

function BuildSourceDirectories()
{
  $sourceDirectoryPath = ".\$ComponentName\src"
  $testsourceDirectoryPath = ".\$ComponentName\testsrc"
  
  if (!(test-path $sourceDirectoryPath))
  {
    New-Item -Path $sourceDirectoryPath -type Directory
    Write-host "`nsrc Directory Created"
  }
  
  if (!(test-path $testsourceDirectoryPath))
  {
    New-Item -Path $testsourceDirectoryPath -type Directory
    Write-host "`ntestsrc Directory Created"
  }
  
  
  $sourceDirectoryPath = "$sourceDirectoryPath\com"
  $testsourceDirectoryPath = "$testsourceDirectoryPath\com"
  
  if (!(test-path $sourceDirectoryPath))
  {
    New-Item -Path $sourceDirectoryPath -type Directory
    Write-host "`nsrc\com Directory Created"  
  }
  
  if (!(test-path $testsourceDirectoryPath))
  {
    New-Item -Path $testsourceDirectoryPath -type Directory
    Write-host "`ntestsrc\com Directory Created"  
  }
  
  $sourceDirectoryPath = "$sourceDirectoryPath\dscomponent"
  $testsourceDirectoryPath = "$testsourceDirectoryPath\dscomponent"
  
  if (!(test-path $sourceDirectoryPath))
  {
    New-Item -Path $sourceDirectoryPath -type Directory
    Write-host "`nsrc\com\dscomponent Directory Created"  
  }
  
  if (!(test-path $testsourceDirectoryPath))
  {
    New-Item -Path $testsourceDirectoryPath -type Directory
    Write-host "`ntestsrc\com\dscomponent Directory Created"  
  }
  
  if (!(test-path $sourceDirectoryPath\build.xml))
  {
    New-Item -Path $sourceDirectoryPath\build.xml -type File
    Write-host "`nBuild.xml file added under src\com\dscomponent"    
  }
 
  if (!(test-path $testsourceDirectoryPath\build.xml))
  {
    New-Item -Path $testsourceDirectoryPath\build.xml -type File
    Write-host "`nBuild.xml file added under testsrc\com\dscomponent"    
  }
}

function BuildReadMeFile()
{
  if (!(test-path .\$ComponentName\README.md))
  {
    New-Item -Path .\$ComponentName\README.md -type File
    Write-host "`nREADME.md file added .\$ComponentName Folder"    
  }
}

try
{
  Write-Host "`n`n`t Initializing Component: $ComponentName`n`n"
  BuildComponentDirectory 
  BuildSourceDirectories 
  BuildReadMeFile
  Write-Host "`n`n`t Initializing Completed"
  pushd .\$ComponentName
}
finally
{
}