import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;

public class MyContentProvider extends ContentProvider {
    private static final String AUTHORITY ="com.example.carla.calllog.MyContentProvider";
    private static final String PRODUCTS_TABLE = "productos";
    public static final Uri CONTENT_URI =Uri.parse("content://" + AUTHORITY + "/" + PRODUCTS_TABLE);
    public MyContentProvider() {
    }
    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
// TODO; Completar.
        throw new UnsupportedOperationException("No implementado");
    }
    @Override
    public String getType(Uri uri) {
// TODO: Completar.
        throw new UnsupportedOperationException("No implementado");
    }
    @Override
    public Uri insert(Uri uri, ContentValues values) {
// TODO: Completar.
        throw new UnsupportedOperationException("No implementado");
    }
    @Override
    public boolean onCreate() {
// TODO: Completar.
        return false;
    }
    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
// TODO: Completar.
        throw new UnsupportedOperationException("No implementado");
    }
    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
// TODO: Completar
        throw new UnsupportedOperationException("No implementado");
    }
}
