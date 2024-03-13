JFLAGS = -g
JC = /usr/bin/javac

.SUFFIXES: .java .class
BINDIR = bin
SRCDIR = src

$(BINDIR)/%.class: $(SRCDIR)/%.java
	$(JC) -d $(BINDIR) -cp $(BINDIR) $<

.java.class:
	$(JC) $(JFLAGS) $*.java

SRC_FILES = BinarySearchTreeKB.java BSTNode.java Generic.java GenericsKbArrayApp.java GenericsKbBSTApp.java
JAVADOC = doc

CLASSES= \
BinarySearchTreeKB.java \
BSTNode.java \
Generic.java \
GenericsKbArrayApp.java \
GenericsKbBSTApp.java

CLASS_FILES= $(CLASSES:%.java=$(BINDIR)/%.class)

default: classes run

classes: $(CLASS_FILES)

javadoc: $(SRC_FILES)
	mkdir -p $(JAVADOC)
	javadoc -d $(JAVADOC) $(SRC_FILES)

compile: $(CLASS_FILES)

clean:
	$(RM) $(BINDIR)/*.class

run:
	java -cp $(BINDIR) GenericsKbAVLApp

