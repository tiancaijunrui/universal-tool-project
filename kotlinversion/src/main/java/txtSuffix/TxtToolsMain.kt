import org.junit.Test
import java.io.File
import java.nio.charset.Charset

/**
 * @Since2018/1/2 ZhaCongJie@HF
 */
class TxtToolsMain {
    /**
     * 文件路径，如果文件不存在，则创建文件
     */
    fun getFile(path: String): File {
        val file = File(path)
        if (!file.exists()) {
            file.createNewFile()
        }
        return file;
    }

    /**
     * 读取文件
     */
    fun readFile(file: File): MutableList<String> {
        val list = mutableListOf<String>()
        file.readLines(Charset.defaultCharset()).forEach {
            // 业务处理
            println(it)
            list.add(it)
        }
        return list
    }

    /**
     * 写入文件
     * @param list 要写入的内容，循环遍历，每循环一次，换行
     * @param rewrite 是否重写,true : 重写，false 追加
     * @param file 操作的文件名称
     * @return true 写入成功，false 写入失败
     */
    fun writeFile(list: MutableList<String>, rewrite: Boolean, file: File): Boolean {
        if (rewrite) {
            file.writeText("")
        }
        for ((index,str) in list.withIndex()) {
            file.appendText(str)
            if (index != list.size){
                file.appendText("\n")
            }
        }
        return true
    }

    @Test
    fun test1() {
        val path = "D:\\record_id.txt"
        val file = getFile(path)
    }

    @Test
    fun test2() {
        val path = "D:\\record_id.txt"
        readFile(getFile(path))
    }

    @Test
    fun test3() {
        val path = "D:\\record_id.txt"
        writeFile(readFile(getFile(path)), true, getFile("D:\\111.txt"))
    }

}