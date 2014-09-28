Param(
  [Parameter(Mandatory=$true,Position=1)]
  [string]$Component,
  [Parameter(Mandatory=$false,Position=2)]
  [string]$Clean
)

function CompileFromBuildXmlFile ($xmlFile)
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

function CompileComponent()
{
  $srcDirectory = "$Component\src"
  foreach ($item in (Get-ChildItem $srcDirectory -include build.xml -Recurse))
  {
    CompileFromBuildXmlFile $item
  }
}

function CleanFromBuildXmlFile($xmlFile)
{
  [xml] $xDoc = Get-Content $xmlFile
  $baseDir = ".\classes\com\dscomponent"
  
  foreach ($package in $xdoc.BuildCatalog.Packages.Package)
  {
    Write-host "Deleting Package $package"
    if (test-path $baseDir\$package)
    {
      Remove-Item -Recurse $baseDir\$package
    }
  }
}

function CleanComponent()
{
  if (test-path classes)
  {
    Write-host "`n`t Deleting Old Packages`n"
  
    $componentDirectory = "$Component\src"
    foreach ($item in (Get-ChildItem $componentDirectory -include build.xml -Recurse))
    {
      CleanFromBuildXmlFile $item
    }
   
    Write-host "`n`t Deletion Successful!!! "
  }
}

function BuildClassesFolder()
{
  if (!(test-path classes))
  {
      New-Item -path .\classes -type directory
  }
}

try 
{
  if ($Clean)
  {
    cleanComponent
  }
  
  BuildClassesFolder
  
  Write-host "`n`n`t Building Project $Component `n"
  CompileComponent
  Write-host "`n`n`t Build Successful!!!`n`n"
}
finally
{
}