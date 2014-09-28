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
  $sourceDirectoryPath = ".\$ComponentName"
  
  $sourceDirectoryPath = "$sourceDirectoryPath\src"
  if (!(test-path $sourceDirectoryPath))
  {
    New-Item -Path $sourceDirectoryPath -type Directory
    Write-host "`nsrc Directory Created"
  }
  
  $sourceDirectoryPath = "$sourceDirectoryPath\com"
  if (!(test-path $sourceDirectoryPath))
  {
    New-Item -Path $sourceDirectoryPath -type Directory
    Write-host "`nsrc\com Directory Created"  
  }
  
  $sourceDirectoryPath = "$sourceDirectoryPath\dscomponent"
  if (!(test-path $sourceDirectoryPath))
  {
    New-Item -Path $sourceDirectoryPath -type Directory
    Write-host "`nsrc\com\dscomponent Directory Created"  
  }
  
  if (!(test-path $sourceDirectoryPath\Build.xml))
  {
    New-Item -Path $sourceDirectoryPath\Build.xml -type File
    Write-host "`nBuild.xml file added under src\com\dscomponent"    
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