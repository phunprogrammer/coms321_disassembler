mkdir -p bin

javac -d bin src/disassembler/*.java src/disassembler/instructions/*.java

# Check if compilation was successful
if [ $? -eq 0 ]; then
    echo "Build successful"
else
    echo "Build failed"
fi