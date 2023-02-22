sealed interface LceState {

    data class Error(val th: Throwable?) : LceState

    object Loading : LceState

    data class Content<T>(val data: T) : LceState

}

data class SelectedMember(
    val targetId: String,
    val targetType: MemberType,
    val name: String,
    val groupName: String,
    val avatarUrl: String,
    var authority: DocsAuthority
)


enum class DocsAuthority {
    READ,
    COMMENT,
    EDIT,
    MANAGE
}

enum class MemberType {
    GROUP,
    USER
}



fun main() {
    val a = LceState.Content<List<SelectedMember>>(listOf(
                SelectedMember("",MemberType.GROUP,"c","b","s",DocsAuthority.COMMENT)

    ))
    val b = LceState.Content<List<SelectedMember>>(listOf(

        SelectedMember("",MemberType.GROUP,"c","b","s",DocsAuthority.COMMENT)

    ))
    println(a.equals(b))
}
