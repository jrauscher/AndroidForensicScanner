

$dbfilepaths = Import-Csv targets.csv
cd phoneData
dir

$directory = read-host "`r`nEnter the directory name for your device"
mkdir ..\database\$directory

foreach ($d in $dbfilepaths)
{
    $target = ".\" + $directory + $d.dbFilepaths
    cp $target ..\database\$directory -Verbose
}