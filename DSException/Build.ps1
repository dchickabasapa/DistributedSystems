Param(
  [Parameter(Mandatory=$false,Position=1)]
  [string]$clean
)

function BuildFromXmlFile ($xmlFile, $baseDir)
{
  [xml] $xdoc = Get-Content $xmlFile
  $baseDir = $xmlFile.Directory.FullName
  foreach ($buildItem in $xdoc.BuildCatalog.BuildItems.BuildItem)
  {
    $javaSrcFile = "$baseDir\$buildItem.java"
    Write-host " Building : $javaSrcFile"
    $cmd = "javac -classpath classes -d classes $javaSrcFile"
    cmd /c $cmd
  }
}

function BuildDirectory( $dir )
{
  foreach ($item in (Get-ChildItem . -include build.xml -Recurse -Force))
  {
    BuildFromXmlFile $item
  }
}

function CleanProjects()
{
  Write-host "`n`t Deleting Old Build Files`n"
  if (test-path classes)
  {
    Remove-Item -Recurse classes 
  }
  
  Write-host "`t Deletion Successful!!! "
}

try 
{
  if ($clean)
  {
    cleanProjects
  }
  
  if (!(test-path classes))
  {
      New-Item -path .\classes -type directory
  }
  Write-host "`n`n`t Building Project  `n"
  BuildDirectory "src"
  Write-host "`n`n`t Build Successful!!!"
  
}

finally
{
}